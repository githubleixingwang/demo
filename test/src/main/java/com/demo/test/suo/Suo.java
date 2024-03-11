package com.demo.test.suo;

import static java.lang.Thread.sleep;

/**
 * 初步总结： 如果共享变量属于成员变量使用对象锁；如果共享变量是静态常量使用类锁。
 *
 * 加锁后同步方法中如果操作的是成员变量，
 *   多线程访问类的一个对象时，使用对象锁、类锁效果一致，使用对象锁即可：多线程在访问对象的同步代码时需排队访问，保证对象数据一致性。
 *   多线程访问类的多个对象时，使用对象锁、类锁效果一致，使用对象锁即可：每个对象有一把锁互不影响，每个对象的同步代码需要多个线程进行排队访问，保证每个对象数据一致性。
 *
 * 加锁后同步方法中如果操作的是静态常量，
 *   多线程访问一个对象时，使用对象锁、类锁效果一致，使用对象锁即可：多线程在访问对象的同步代码时需排队访问，保证对象数据一致性。
 *   多线程访问多个对象时，使用对象锁、类锁效果不一致：
 *                    使用对象锁不能保证数据的一致性，只能使用类锁。
 *                    使用类锁，每个对象竞争一把锁，同步代码需要多个对象多个线程都进行排队访问，保证不同对象不同线程读取数据的一致性。
 *
 */
public class Suo {
   // private   Integer count1 = 10;
    private  static Integer count1 = 10;

    /**
     * 对象锁
     */
    public void ticket1() {
        while (true) {
            try {
                sleep(10);//模拟延迟
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (this) {//this 对象锁
                this.count1--;
                if (this.count1 > 0) {
                    System.out.println("对象锁：" + Thread.currentThread().getName() + ",剩余" + this.count1);
                } else {
                    System.out.println("对象锁：" + Thread.currentThread().getName() + "结束");
                    break;
                }
            }
        }
    }

    /**
     * 类锁
     */
    public void ticket2() {
        while (true) {
            try {
                sleep(10);//模拟延迟
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (Suo.class) {//类锁
                this.count1--;
                if (this.count1 > 0) {
                    System.out.println("类锁：" + Thread.currentThread().getName() + ",剩余" + this.count1);
                } else {
                    System.out.println("类锁：" + Thread.currentThread().getName() + "结束");
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        //不管如何加锁，都是控制都这个方法或代码块的访问，而不是整个类，这点不要忘记了
//******************************************************************  对象锁  ****************************************************************
        //多个线程访问一个对象的成员变量： 一个对象的同步方法只允许多个线程进行排队访问
        /*final Suo suo1 = new Suo();
        new Thread("多个线程访问一个对象的成员变量-线程1") { public void run() {suo1.ticket1();}}.start();
        new Thread("多个线程访问一个对象的成员变量-线程2") {public void run() {suo1.ticket1();}}.start();
        new Thread("多个线程访问一个对象的成员变量-线程3") {public void run() {suo1.ticket1();}}.start();
        new Thread("多个线程访问一个对象的成员变量-线程4") {public void run() {suo1.ticket1();}}.start();*/
        /*new Thread("多个线程访问一个对象的成员变量-线程1") { public void run() {suo1.ticket2();}}.start();
        new Thread("多个线程访问一个对象的成员变量-线程2") {public void run() {suo1.ticket2();}}.start();
        new Thread("多个线程访问一个对象的成员变量-线程3") {public void run() {suo1.ticket2();}}.start();
        new Thread("多个线程访问一个对象的成员变量-线程4") {public void run() {suo1.ticket2();}}.start();*/

       //两个对象多个线程： 两个对象的锁互不影响；每个对象的同步方法只允许多个线程排队访问
        /*final Suo suo2 = new Suo();
        final Suo suo3 = new Suo();
        new Thread("多个线程访问多个对象的成员变量-线程1") { public void run() {suo2.ticket1();}}.start();
        new Thread("多个线程访问多个对象的成员变量-线程2") {public void run() {suo2.ticket1();}}.start();
        new Thread("多个线程访问多个对象的成员变量-线程3") { public void run() {suo3.ticket1();}}.start();
        new Thread("多个线程访问多个对象的成员变量-线程4") {public void run() {suo3.ticket1();}}.start();*/
        /*final Suo suo7 = new Suo();
        final Suo suo8 = new Suo();
        new Thread("多个线程访问多个对象的成员变量-线程1") { public void run() {suo7.ticket2();}}.start();
        new Thread("多个线程访问多个对象的成员变量-线程2") {public void run() {suo7.ticket2();}}.start();
        new Thread("多个线程访问多个对象的成员变量-线程3") { public void run() {suo8.ticket2();}}.start();
        new Thread("多个线程访问多个对象的成员变量-线程4") {public void run() {suo8.ticket2();}}.start();*/
//****************************************************************  类锁  ****************************************************************
        //多个线程访问一个对象的成员变量： 一个对象的同步方法只允许多个线程进行排队访问
       /* final Suo suo4 = new Suo();
        new Thread("多个线程访问一个对象的成员变量-线程1") { public void run() {suo4.ticket1();}}.start();
        new Thread("多个线程访问一个对象的成员变量-线程2") {public void run() {suo4.ticket1();}}.start();*/
        /*new Thread("多个线程访问一个对象的成员变量-线程1") { public void run() {suo4.ticket2();}}.start();
        new Thread("多个线程访问一个对象的成员变量-线程2") {public void run() {suo4.ticket2();}}.start();*/

        //两个对象多个线程：
        // 对成员变量 两个对象的锁互不影响；每个对象的同步方法只允许多个线程排队访问
        // 对静态变量 两个对象的锁有影响；静态变量只允许每个对象的同步方法和多个线程一起排队访问
        final Suo suo5 = new Suo();
        final Suo suo6 = new Suo();
        /*new Thread("多个线程访问多个对象的成员变量-线程1") { public void run() {suo5.ticket1();}}.start();
        new Thread("多个线程访问多个对象的成员变量-线程2") {public void run() {suo5.ticket1();}}.start();
        new Thread("多个线程访问多个对象的成员变量-线程3") { public void run() {suo6.ticket1();}}.start();
        new Thread("多个线程访问多个对象的成员变量-线程4") {public void run() {suo6.ticket1();}}.start();*/
        /*new Thread("多个线程访问多个对象的成员变量-线程1") { public void run() {suo5.ticket2();}}.start();
        new Thread("多个线程访问多个对象的成员变量-线程2") {public void run() {suo5.ticket2();}}.start();
        new Thread("多个线程访问多个对象的成员变量-线程3") { public void run() {suo6.ticket2();}}.start();
        new Thread("多个线程访问多个对象的成员变量-线程4") {public void run() {suo6.ticket2();}}.start();*/

    }


    /*Lock lock = new ReentrantLock();
     lock.lock();
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
