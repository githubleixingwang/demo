package com.demo.mybatis.controller;

import com.demo.mybatis.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/alert")
@RestController
public class AlertController {

    @Autowired
    private AlertService service;

    @GetMapping("/init")
    public Map<String,String> init(){
        return service.init();
    }

    @GetMapping("/count")
    public Map<String,Object> count(){
        return service.count();
    }


}
