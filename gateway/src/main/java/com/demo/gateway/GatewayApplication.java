package com.demo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class GatewayApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(new Class[] { GatewayApplication.class }).web(WebApplicationType.REACTIVE).run(args);
        //new SpringApplicationBuilder(new Class[] { GatewayApplication.class }).web(WebApplicationType.SERVLET).run(args);
        //SpringApplication.run(GatewayApplication.class,args);
    }
}
