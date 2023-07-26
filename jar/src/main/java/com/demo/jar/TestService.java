package com.demo.jar;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author: lxw
 * @date: 2023-07-26  15:58
 */
@Service
public class TestService {

    @Async("threadPoolExecutor")//使用自定义的线程池，若不指定则使用默认的线程池
    public void a(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(i);
    }

    @Async("threadPoolExecutor2")//使用自定义的线程池，若不指定则使用默认的线程池
    public void b(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(i);
    }
}
