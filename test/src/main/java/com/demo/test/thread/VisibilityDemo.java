package com.demo.test.thread;

public class VisibilityDemo {
    private static boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {

            while (running) {
                System.out.println("线程1正在运行...");
// 线程1可能无法感知running的变化

            }

        }).start();

        Thread.sleep(1000);

        running = false; // 线程2修改标志位

    }

}
