package com.demo.nacos;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.reactive.EmptyResponse;
import org.springframework.cloud.client.loadbalancer.reactive.DefaultResponse;
import org.springframework.cloud.client.loadbalancer.reactive.Request;
import org.springframework.cloud.client.loadbalancer.reactive.Response;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Mono;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
public class WeightedLoadBalancer implements ReactorServiceInstanceLoadBalancer {

    private final ServiceInstanceListSupplier supplier;

    public WeightedLoadBalancer(ServiceInstanceListSupplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        return supplier.get().next().map(this::chooseInstance);
    }

    private Response<ServiceInstance> chooseInstance(List<ServiceInstance> instances) {
        if (instances.isEmpty()) {
            return new EmptyResponse();
        }

        double totalWeight = 0;
        for (ServiceInstance instance : instances) {
            totalWeight += getWeight(instance);
        }

        double random = Math.random() * totalWeight;
        double current = 0;
        for (ServiceInstance instance : instances) {
            current += getWeight(instance);
            if (random <= current) {
                return new DefaultResponse(instance);
            }
        }

        return new DefaultResponse(instances.get(instances.size() - 1));
    }

    private double getWeight(ServiceInstance instance) {
        String weight = instance.getMetadata().get("nacos.weight");
        return weight != null ? Double.parseDouble(weight) : 1.0;
    }
}