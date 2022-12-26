package com.demo.vue.test.ratelimit;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter;

public class GoogleRateLimit {

    public static void main(String[] args) throws InterruptedException {
        //每秒产生令牌数
        RateLimiter rateLimiter = RateLimiter.create(1.00);
        //记录时间
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 10; i++) {
            rateLimiter.acquire();
            System.out.println(i+Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println(i+Thread.currentThread().getName());

        }
        stopwatch.stop();
        System.out.println(stopwatch);



    }
}
