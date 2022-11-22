package com.demo.mybatis.service;

import com.demo.mybatis.dao.AlertMapper;
import com.demo.mybatis.domain.Alert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AlertService {

    @Resource
    private AlertMapper mapper;

    private Random random = new Random(System.currentTimeMillis());

    public Map<String,String> init() {
        HashMap<String, String> map = new HashMap<>();

        int count = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            long ts = System.currentTimeMillis();
            Alert alert = new Alert();
            alert.setEsn("10000000001");
            alert.setAlertTime(new Date());
            alert.setAlertModel("02");
            alert.setAppName("应用");
            alert.setContainerName("容器");
            alert.setEvent("02");
            alert.setInsertTime(new Date());
            alert.setMsg("告警信息");
            alert.setLevel("02");
            count +=  mapper.insert(alert);
        }
        long end = System.currentTimeMillis();
        map.put("time",String.valueOf((end-start)/1000));
        map.put("count",String.valueOf(count));
        return map;
    }

    public Map<String,Object> count() {
        HashMap<String, Object> map = new HashMap<>();

        long start = System.currentTimeMillis();
        int count = mapper.count();
        long end = System.currentTimeMillis();
        map.put("count-time",(((double)(end-start))/1000 +"秒" ));
        map.put("count",String.valueOf(count));

        long start2 = System.currentTimeMillis();
        Page<Object> page = PageHelper.startPage(1, 10,true);
        List<Alert> list = mapper.select();
        long end2 = System.currentTimeMillis();
        map.put("time2",(((double)(end2-start2))/1000 +"秒" ));

        map.put("list",list);

        return map;
    }

}
