package com.demo.test.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StringRangeTest {

    @Autowired
    private StringRange stringRange;

    @Test
    public void test1() {
        stringRange.test1();
    }

    @Test
    public void test2() {
        stringRange.test2();
    }
}