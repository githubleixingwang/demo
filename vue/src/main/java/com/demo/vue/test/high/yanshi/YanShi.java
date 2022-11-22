package com.demo.vue.test.high.yanshi;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 延时执行实现
 */
@Component
public class YanShi {

    public static void main(String[] args) throws InterruptedException {
        //每秒产生令牌数
        RateLimiter rateLimiter = RateLimiter.create(1);

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);
        //需求： 将list 分批 间隔 输出
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        System.out.println("主线程：" + Thread.currentThread().getName());
        int sub = 3;//单批次数量

        double c = (((double) integers.size()) / sub);
        int a = (int) Math.ceil(c); //批次

        int time = 5;//间隔
        for (int i = 0; i < a; i++) {
            int index = i;
            int start = index * sub;
            int end;
            if (index == a - 1) {
                end = integers.size();
            } else {
                end = index * sub + sub;

            }

           /* 方法1 主线程延迟执行
           Thread.sleep(3000);
            System.out.println(integers.subList(start,end));*/
           //方法2 线程池schedule执行
            service.schedule(() -> {
               integers.subList(start, end).stream().forEach(t -> {
                   rateLimiter.acquire();
                   System.out.println(t);
               });
            }, index * time, TimeUnit.SECONDS);

        }


    }

    static class A {
        public void a() {
            System.out.println("延时" + Thread.currentThread().getName());
        }

    }
}
