package com.demo.moudleOne.json;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/json")
@RestController
public class TestWeb {

    @PostMapping("/test1")
    private void jsonTest(@RequestBody  JsonVo vo){
        System.out.println(vo.getArr());
        System.out.println(vo.getObj());
    }
}

