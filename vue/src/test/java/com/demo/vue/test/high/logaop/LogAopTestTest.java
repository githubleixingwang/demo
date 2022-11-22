package com.demo.vue.test.high.logaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LogAopTestTest {

    @Autowired
    private LogAopTest logAopTest;

    @Test
    public void a() {
        logAopTest.a("1","2");
    }
}