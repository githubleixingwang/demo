package com.demo.vue.test.suo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Suo {

    int count = 100;
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        final Suo test = new Suo();
        for (int i = 0; i < 100; i++) {
            new Thread("甲" + i) {
                public void run() {
                    test.insert(Thread.currentThread());
                }

                ;
            }.start();
            new Thread("乙" + i) {
                public void run() {
                    test.insert(Thread.currentThread());
                }

                ;
            }.start();
            new Thread("丙" + i) {
                public void run() {
                    test.insert(Thread.currentThread());
                }

                ;
            }.start();
        }

    }

    public void insert(Thread thread) {
        synchronized (this) {
        this.count--;
        //线程获取到了锁
        if (count > 0) {
            System.out.println("线程" + thread.getName() +",剩余"+ this.count);
        }
        }
       /* lock.lock();
        try {
            //线程获取到了锁
            for (int i = 0; i < 2; i++) {
                arrayList.add("第" + count + "次" + "线程" + thread.getName() + i);
            }
        } catch (Exception e) {

        } finally {
            //线程释放锁
            lock.unlock();
        }*/
    }
}
