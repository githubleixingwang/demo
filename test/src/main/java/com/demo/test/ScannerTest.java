package com.demo.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScannerTest {

    public static volatile int count = 0;

    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        StringBuilder stringBuilder = new StringBuilder(next);
        System.out.println("输入信息反向输出：" + stringBuilder.reverse());
        */
        ExecutorService exe = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            exe.execute(new Runnable() {
                @Override
                public void run() {

                    count++;
                    System.out.println(Thread.currentThread().getName() + ":" + count);


                }
            });
        }
        System.out.println(Thread.currentThread().getName() + ":" + count);
    }
}
