package com.demo.vue.test.base.queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QueueTestTest {

    @Autowired
    private QueueTest queueTest;

    @Test
    public void bloching() throws InterruptedException {
        queueTest.bloching();
    }
}