package com.example.item;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试数据
 *
 * @author MaoHao
 * @date 2020年04月13日 9:18
 */
public class SomeStuff {
    private static Lock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();

    public static void main(String[] arg) {
        new Thread(new MyThread1(), "t1").start();
        new Thread(new MyThread2(), "t2").start();
    }

    static class MyThread1 implements Runnable {
        public void run() {
            lock.lock();
            try {
                condition2.signal();
                condition1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                for (int i = 0; i < 5; i++)
                    System.out.println(Thread.currentThread().getName() + ":" + i);
            } finally {
                lock.unlock();
            }
        }
    }

    static class MyThread2 implements Runnable {
        public void run() {
            lock.lock();
            try {
                condition1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                for (int i = 0; i < 5; i++)
                    System.out.println(Thread.currentThread().getName() + ":" + i);
            } finally {
                condition2.signal();
                lock.unlock();
            }
        }
    }

}

