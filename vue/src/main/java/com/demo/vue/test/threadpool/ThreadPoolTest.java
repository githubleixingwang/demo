package com.demo.vue.test.threadpool;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.concurrent.*;

@Component
public class ThreadPoolTest {

    public void test() {

        Executors.newCachedThreadPool();

        //定长线程池，全部是核心线程，用完立即回收
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // 创建一个可缓存线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(3);
        //自定义线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        for (int i = 0; i < 10; i++) {
//            try {
//                // sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            executorService.execute(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        // sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName());

                }
            });
        }
    }

    public void test2() {

//        Executors.newCachedThreadPool();
//
//        //定长线程池，全部是核心线程，用完立即回收
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        // 创建一个可缓存线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        Executors.newScheduledThreadPool(3);
//        //自定义线程池
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
//        for (int i = 0; i < 10; i++) {
////            try {
////                // sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
////                Thread.sleep(1000);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
////                    try {
////                        // sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
////                        Thread.sleep(5000);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
//                    System.out.println(Thread.currentThread().getName() );
//
//                }
//            });
//        }
//    }
        int id = 0;
        int count = 30000;
        int maxId = id + 10;
        HashSet<Object> objects = new HashSet<>();
      //  Set<Object> objects1 = Collections.synchronizedSet(objects);
        while (id < count) {
            int a = id;
            int b = maxId;
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    objects.add(a);
                }
            });
            id += 10;
            maxId += 10;
        }
        System.out.println(objects.size());
        System.out.println(objects);

    }
}
