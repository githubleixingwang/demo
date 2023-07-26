package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableDiscoveryClient //表示eurake客户端
@EnableAsync
@EnableScheduling
public class JarApplication {
    public static void main(String[] args) {
        SpringApplication.run(JarApplication.class, args);
    }

}
