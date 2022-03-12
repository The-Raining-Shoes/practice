package com.example.item.thread.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock的实现类，reentrantLock的简单实现
 */
public class LockTest {

    public static void main(String[] args) {
        Tickets2 tickets2 = new Tickets2();
        new Thread(() -> {for (int i = 0; i < 50; i++) tickets2.sale();}, "A").start();
        new Thread(() -> {for (int i = 0; i < 50; i++) tickets2.sale();}, "B").start();
        new Thread(() -> {for (int i = 0; i < 50; i++) tickets2.sale();}, "C").start();
    }

}

class Tickets2 {

    private int num = 30;

    // 默认非公平锁
    Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了" + num + "张票,还剩余" + --num + "张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}