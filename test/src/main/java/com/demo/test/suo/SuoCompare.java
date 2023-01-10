package com.demo.test.suo;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class SuoCompare {
    int a = 0;
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void Sync() {
        for (int i = 0; i < 100; i++) {

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    synchronized (this) {
                        add(Thread.currentThread());
                    }
                }
            });
        }


    }


    public void add(Thread thread){
        a++;
        System.out.println(a + "  " + thread.getName());
    }

}
