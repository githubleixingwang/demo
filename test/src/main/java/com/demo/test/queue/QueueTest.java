package com.demo.test.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * 队列
 */
@Slf4j
@Component
public class QueueTest {

    public void bloching() throws InterruptedException {

        //基于数组的有界阻塞队列
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(10);

        //基于链表的有界阻塞队列
        LinkedBlockingDeque<Integer> linkedBlockingDeque1 = new LinkedBlockingDeque<>(10);

        //基于链表的无界阻塞队列
        LinkedBlockingDeque<Integer> linkedBlockingDeque2 = new LinkedBlockingDeque<>();

        //非阻塞队列
        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    //arrayBlockingQueue.put(i);
                    linkedBlockingDeque2.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.setName("线程1");
        thread1.start();
        Thread thread2 = new Thread(() -> {

        });
        thread2.setName("线程2");
        thread2.start();


        System.out.println("有界阻塞队列" + arrayBlockingQueue);
        System.out.println("有界阻塞队列" + linkedBlockingDeque1);
        System.out.println("无界阻塞队列" + linkedBlockingDeque2);
        System.out.println(concurrentLinkedQueue);
        TimeUnit.SECONDS.sleep(10);
        System.out.println("thread1状态：" + thread1.getState() + ",是否活跃:" + thread1.isAlive());
        System.out.println("thread2状态：" + thread2.getState() + ",是否活跃:" + thread2.isAlive());

    }
}
