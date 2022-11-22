package com.demo.moudleOne.feigen;

import com.demo.moudleOne.todo.java.Vo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RequestMapping("/feign")
@RestController
public class FeignWeb {

    @Resource
    private AllClient client;

    @Resource
    private AllClient2 client2;

    @PostMapping("/test1")
    public Map<String,Object> test1( ){
       return client.feignTest();
    }

    @PostMapping("/test2")
    public String test2(Vo vo ){
        return client2.feignTest(vo);
    }
}
