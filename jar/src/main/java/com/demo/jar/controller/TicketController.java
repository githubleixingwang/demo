package com.demo.jar.controller;

import com.demo.jar.service.TicketDiTieService;
import com.demo.jar.vo.DitieVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: lxw
 * @date: 2023-07-27  14:49
 */

@RestController
@RequestMapping("/ticket")
public class TicketController {

    public volatile static int count = 10;

    @Resource
    private ThreadPoolExecutor threadPoolExecutorTicket;
    @Resource
    private TicketDiTieService ticketDiTieService;

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

    @RequestMapping("/ditie")
    public Map<String, Object> ditie(@RequestBody List<DitieVo> list) {
        Map<String, Object> map = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (DitieVo vo : list) {
                if (StringUtils.isNotBlank(vo.getPhone()) && StringUtils.isNotBlank(vo.getSubway()) && vo.getNum() != 0) {
                    ticketDiTieService.ditie(vo.getPhone(), vo.getSubway().split("-")[0], vo.getSubway().split("-")[1], vo.getNum());
                    subtraction();
                }
            }
        }
        map.put("count", count);
        return map;
    }
    @RequestMapping("/getCount")
    public Map<String, Object> getCount() {
        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        return map;
    }
}
