package com.demo.vue.test.suo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SuoCompareTest {

    @Autowired
    private SuoCompare suoCompare;

    @Test
    public void sync() {
        suoCompare.Sync();
    }
}