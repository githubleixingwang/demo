package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;


@MapperScan({"com.demo.vue.dao","com.demo.common.mapper"})  //项目启动时会扫描mapper包及子包的接口，否则会报错找不到mapper文件
@SpringBootApplication
@EnableDiscoveryClient //表示eurake客户端
@EnableAsync
public class VueApplication {
    public static void main(String[] args) {
        SpringApplication.run(VueApplication.class, args);
    }

}
