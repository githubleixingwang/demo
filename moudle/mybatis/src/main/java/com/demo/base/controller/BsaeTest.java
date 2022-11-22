package com.demo.base.controller;

import com.demo.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequestMapping("/base")
@RestController
public class BsaeTest {

    @Autowired
    private BaseService service;

//    @GetMapping("/a")
//    public Map<String,Object> a (){
//        Map<String, Object> map = service.a();
//        return  map;
//
//    }
}
