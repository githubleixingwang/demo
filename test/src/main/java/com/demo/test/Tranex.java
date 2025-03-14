package com.demo.test;

import com.demo.test.mybatisplus.DemoTest1ServiceImpl;
import com.demo.test.mybatisplus.DemoTest2ServiceImpl;
import com.demo.test.po.DemoTest1;
import com.demo.test.po.DemoTest2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Tranex {

    @Autowired
    private DemoTest1ServiceImpl demoTest1ServiceImpl;
    @Autowired
    private DemoTest2ServiceImpl demoTest2ServiceImpl;

    public String ex() {
        String str = null;

        DemoTest1 demoTest1 = new DemoTest1();
        demoTest1.setName("a");
        demoTest1ServiceImpl.save(demoTest1);

        DemoTest2 demoTest2 = new DemoTest2();
        demoTest2.setName(demoTest1.getId().toString());
        demoTest2ServiceImpl.save(demoTest2);
int a =1/0;
        str="1";
        return str;

    }
}
