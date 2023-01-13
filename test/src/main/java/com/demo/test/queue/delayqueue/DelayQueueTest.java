package com.demo.test.queue.delayqueue;

import org.springframework.boot.CommandLineRunner;

import java.util.Date;
import java.util.concurrent.DelayQueue;

/**
 * @author: lxw
 * @date: 2023-01-12  17:12
 */
public class DelayQueueTest implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        new DelayQueueTest().run();
    }


    @Override
    public void run(String... args) throws Exception {
        DelayQueue<DelayTask> delayQueue = new DelayQueue<>();
        DelayTask delayTask = new DelayTask();
        delayQueue.add(delayTask);
        delayQueue.add(delayTask);
        int size = delayQueue.size();
        for (int i = 0; i < size; i++) {
            DelayTask poll = delayQueue.poll();
            if (poll != null) {
                System.out.println("执行时间：" + new Date());
            }
        }

       /* while (true) {
            try {
                DelayTask task = delayQueue.take();
                System.out.println("执行时间：" + new Date());
            } catch (InterruptedException e) {
                break;
            }
        }*/
    }
}
