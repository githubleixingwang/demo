package com.demo.test.list.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class ListConCurrentTest {

    public static void main(String[] args) throws InterruptedException {
        //List<Object> list = new ArrayList<>();
        //List<Object> list = Collections.synchronizedList(new ArrayList<>());
        List<Integer> list = new CopyOnWriteArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            int tem = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(tem);
                    System.out.println(list);
                }
            });
//            new Thread(()->{
//                list.add(tem);
//                System.out.println(list);
//            }).start();

        }
    }
}
