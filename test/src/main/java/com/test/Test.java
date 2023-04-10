package com.test;

/**
 * @author LXW
 * @date 2023/3/27
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(1);
                System.out.println(Thread.currentThread().getName());
                System.out.println(currentThread().getName());
            }
        };
        thread.start();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println(2);
                System.out.println(Thread.currentThread().getName());
                System.out.println(currentThread().getName());
            }
        };
        thread1.start();

        new Thread(()->{
            System.out.println(3);
            System.out.println(Thread.currentThread().getName());
        }).start();
        System.out.println(Thread.currentThread().getName());
    }
}
