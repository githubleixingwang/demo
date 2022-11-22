package com.demo.moudleOne.feigen;

import com.demo.moudleOne.todo.java.Vo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient( name = "TEST2" ,url = "127.0.0.1:8666/wrapper",configuration = FeignConfig.class)
public interface AllClient2 {
    @PostMapping("/test1")
    public String feignTest(Vo vo );
}
