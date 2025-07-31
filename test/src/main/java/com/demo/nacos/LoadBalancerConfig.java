package com.demo.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.List;

@Configuration
public class LoadBalancerConfig {

    @Bean
    public ServiceInstanceListSupplier serviceInstanceListSupplier(
            DiscoveryClient discoveryClient,
            @Value("${spring.application.name}") String serviceId
    ) {
        return new SimpleServiceInstanceListSupplier(discoveryClient, serviceId);
    }

    @Bean
    public ReactorServiceInstanceLoadBalancer weightedLoadBalancer(
            ServiceInstanceListSupplier supplier
    ) {
        return new WeightedLoadBalancer(supplier);
    }
}