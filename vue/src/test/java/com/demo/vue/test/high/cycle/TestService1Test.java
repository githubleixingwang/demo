package com.demo.vue.test.high.cycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestService1Test {

    @Autowired
    private TestService1 testService1;

    @Test

    public void test() {
        log.info("主线程开始{},{}", Thread.currentThread().getName(), Thread.currentThread().getId());
      //  for (int i = 0; i < 3; i++) {
          //  log.info("循环异步{},{}", Thread.currentThread().getName(), Thread.currentThread().getId());
            testService1.test1();
       // }
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    log.info("一个线程{},{}", Thread.currentThread().getName(), Thread.currentThread().getId());
                }
            }
        }).start();
        log.info("主线程结束{},{}", Thread.currentThread().getName(), Thread.currentThread().getId());
    }
}