package com.demo.test.future;


import java.util.concurrent.*;

public class FutureTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            // 模拟耗时操作
            //int a=1/0;
            System.out.println(Thread.currentThread().getName() + "开始执行任务1...");
            Thread.sleep(2000);
            return "任务1完成";
        });

        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "任务2完成");
        });
        executor.shutdown();

        try {
            // 同步等待结果，设置超时时间
            String result = future.get(5, TimeUnit.SECONDS); // 等待5秒
            System.out.println("结果: " + result);
            throw new RuntimeException("");
        } catch (TimeoutException e) {
            System.out.println(e);
            System.out.println("任务1执行超时，未获取到结果");
        } catch (Exception e) {
            System.out.println("通用异常");
            // throw new RuntimeException(e);
        }

        System.out.println("end");

    }
}
