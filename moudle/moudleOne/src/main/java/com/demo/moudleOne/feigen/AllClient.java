package com.demo.moudleOne.feigen;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Component
@FeignClient( name = "TEST" ,url = "127.0.0.1:8667/alert",configuration = FeignConfig.class)
public interface AllClient {
    @GetMapping("/count")
    public Map<String,Object> feignTest( );
}
