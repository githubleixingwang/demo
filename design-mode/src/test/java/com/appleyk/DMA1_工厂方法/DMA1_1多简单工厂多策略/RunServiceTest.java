package com.appleyk.DMA1_工厂方法.DMA1_1多简单工厂多策略;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RunServiceTest {

    @Resource
    private RunService runService;
    @Test
    public void testNormal() {
        runService.testNormal();
    }

    @Test
    public void testTestVip() {
        // Setup
        // Run the test
        runService.testVip();

        // Verify the results
    }

    @Test
    public void testTestVips() {
        // Setup
        // Run the test
        runService.testVips();

        // Verify the results
    }

    @Test
    public void testTestVipss() {
        // Setup
        // Run the test
        runService.testVipss();

        // Verify the results
    }
}