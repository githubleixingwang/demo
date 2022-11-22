package com.demo.vue.test.high.threadpool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ThreadPoolTestTest {

    @Autowired
    private ThreadPoolTest threadPoolTest;

    @Test
    public void test1() {
        threadPoolTest.test();
    }
 @Test
    public void test2() {
        threadPoolTest.test2();
    }

}