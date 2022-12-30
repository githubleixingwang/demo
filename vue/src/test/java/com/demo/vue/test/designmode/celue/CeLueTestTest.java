package com.demo.vue.test.designmode.celue;

import com.demo.vue.test.designmode.celue.CeLueTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CeLueTestTest {

    @Autowired
    private CeLueTest ceLueTest;

    @Test
    public void send() {
        ceLueTest.send("消息");
    }
}