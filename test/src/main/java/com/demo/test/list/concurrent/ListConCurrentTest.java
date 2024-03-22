package com.demo.test.list.concurrent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试list的并发线程安全问题
 */
public class ListConCurrentTest {

    public static void main(String[] args) throws InterruptedException {
        //List<Object> list = new ArrayList<>();
        //List<Object> list = Collections.synchronizedList(new ArrayList<>());//线程安全
        List<Integer> list = new CopyOnWriteArrayList<>();//线程安全，性能较好
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {//模拟10个线程
            //Thread.sleep(10);//需要模拟延迟，测试线程安全
            executorService.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    list.add(j);//list写操作
                }
            });
        }
        executorService.shutdown();//变量方式创建，需要及时关闭
        System.out.println(list.stream().count() + "," + list);
    }
}
