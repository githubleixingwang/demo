package com.demo.vue.test.high.cycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 循环依赖问题
 */
@Service
@Slf4j
public class TestService1 {

    @Autowired
    private TestService2 testService2;

    //@Async
    public void test1() {
        for (int i=0;i<3;i++){
            log.info("多线程执行{}{},{}",Thread.currentThread().getName(),Thread.currentThread().getId() ,i);
        }
    }
}
