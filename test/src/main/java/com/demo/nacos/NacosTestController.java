package com.demo.nacos;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping(value = "/nacos-test")
@RefreshScope
public class NacosTestController {

    @Autowired
    @Qualifier("nacosRestTemplate")
    private RestTemplate nacosRestTemplate;

  /*  @Autowired
    private LoadBalancerClient loadBalancerClient;*/

    @Value("${aa.bb}")
    private Boolean bb;
    @GetMapping("/bb")
    public Boolean test() {
        return bb;
    }
    @GetMapping("/cc")
    public Boolean test2() throws NacosException {
        Properties properties = new Properties();
        properties.setProperty("serverAddr", "127.0.0.1:8848");
        properties.setProperty("namespace", "test"); // 指定命名空间ID
        properties.setProperty("group", "DEFAULT_GROUP"); // 指定组
        properties.setProperty("username", "nacos");
        properties.setProperty("password", "nacos");
        NamingService naming = NamingFactory.createNamingService(properties);
        List<Instance> instances = naming.getAllInstances("test");

        if (instances.isEmpty()) {
            throw new RuntimeException("No instances found");
        }

        Instance instance = instances.get(0);
        String url = "http://" + instance.getIp() + ":" + instance.getPort() + "/nacos-test/bb";
        return nacosRestTemplate.getForObject("http://test/nacos-test/bb", Boolean.class);
        //return nacosRestTemplate.getForObject(url, Boolean.class);
    }
    // 使用服务名调用
}
