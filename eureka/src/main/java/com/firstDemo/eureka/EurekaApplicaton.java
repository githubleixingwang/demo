package com.demo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author LXW
 * @date 2020/04/25 17:11
 */
@EnableEurekaServer
@SpringBootApplication

public class EurekaApplicaton {
	public static void main(String[] args) {
		//new SpringApplicationBuilder(new Class[] { EurekaApplicaton.class }).web(WebApplicationType.SERVLET).run(args);
		SpringApplication.run(EurekaApplicaton.class,args);
	}
}
