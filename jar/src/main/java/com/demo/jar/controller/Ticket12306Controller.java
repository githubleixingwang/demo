package com.demo.jar.controller;

import com.demo.jar.service.Ticket12306Service;
import com.demo.jar.vo.Ticket12306Vo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lxw
 * @date: 2024-01-25  10:08
 */
@RestController
@RequestMapping("/ticket")
public class Ticket12306Controller {
    public volatile static int count = 10;

    @Resource
    private Ticket12306Service ticket12306Service;

    public static synchronized void subtraction() {
        count--;
    }

    public static synchronized void addition() {
        //非核心线程空闲10秒自动回收
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        count++;
    }

    @RequestMapping("/ticket12306")
    public Map<String, Object> ticket12306(Ticket12306Vo vo) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(vo.getSeats()) && StringUtils.isNotBlank(vo.getPsw()) && StringUtils.isNotBlank(vo.getPassenger())) {
            ticket12306Service.ticket12306(vo);
            subtraction();
        }
        map.put("count", count);
        return map;
    }
}
