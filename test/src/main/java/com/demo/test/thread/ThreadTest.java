package com.demo.test.thread;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.*;
import java.util.Map;

public class ThreadTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            executor.execute(() -> {
                try {
                    System.out.println("bbbb");
                    int a = 1 / 0;
                } catch (Exception e) {
                    throw new RuntimeException("aaa");
                }
            });
        } catch (Exception e) {
            //不会捕捉到新启线程的异常信息
            System.out.println("其他线程异常");
        }
        getAllThread();
        executor.shutdown();
        getAllThread();
        // 创建一个单线程的调度执行器
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        // 每5秒执行一次 getAllThread 方法
        ScheduledFuture<?> scheduledFuture = scheduler.scheduleAtFixedRate(() -> {
            System.out.println("执行调度");
            getAllThread();
        }, 0, 5, TimeUnit.SECONDS);
        // 主线程等待一段时间，以确保调度任务有足够的时间执行
        try {
            Thread.sleep(1000); // 主线程等待10秒
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        scheduledFuture.cancel(true);// 周期性中断任务
        // 关闭调度器：默认行为是立即停止所有未启动的延迟/周期性任务，但已开始执行的任务会继续运行
        scheduler.shutdown();
        getAllThread();
    }

    public static void getAllThread() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            Thread thread = entry.getKey();
            if (thread.getName().startsWith("pool")) {
                System.out.println("Thread: " + thread.getName());
            }
        }
        System.out.println("###################################################");
    }
}
