package com.demo.test.callback;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RuleTest {

    @Autowired
    private ACallBackTest a;

    @Test
    public void a() {
        a.a();
    }
}