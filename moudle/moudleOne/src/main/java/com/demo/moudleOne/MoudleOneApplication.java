package com.demo.moudleOne;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LXW
 * @date 2020/04/03 21:30
 */
@MapperScan("com.demo.common.mapper")  //项目启动时会扫描mapper包及子包的接口，否则会报错找不到mapper文件
@SpringBootApplication
@EnableDiscoveryClient //表示eurake客户端
@EnableFeignClients    //用Feign方式调用
public class MoudleOneApplication {

		public static void main(String[] args) {
			SpringApplication.run(MoudleOneApplication.class, args);

	}
}
