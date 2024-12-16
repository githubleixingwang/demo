package com.demo.test;

import com.demo.test.mybatisplus.DemoTest1ServiceImpl;
import com.demo.test.mybatisplus.DemoTest2ServiceImpl;
import com.demo.test.po.DemoTest1;
import com.demo.test.po.DemoTest2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoTestController {

    @Autowired
    private DemoTest1ServiceImpl demoTest1ServiceImpl;
    @Autowired
    private DemoTest2ServiceImpl demoTest2ServiceImpl;

    @GetMapping(value = "/mybatisplus")
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        DemoTest1 demoTest1 = new DemoTest1();
        demoTest1.setName("a");
        demoTest1ServiceImpl.save(demoTest1);
//int a =1/0;
        DemoTest2 demoTest2 = new DemoTest2();
        demoTest2.setName(demoTest1.getId().toString());
        demoTest2ServiceImpl.save(demoTest2);

    }
}
