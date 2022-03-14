package com.example.item.thread.cas;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试可重入锁重复获取锁对象
 */
public class DoubleLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            int i = 1;
            lock.lock();
            do {
                lock.lock();
                try {
                    System.out.println("当前重复获取锁" + i);
                    i++;
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            } while (i <= 10);
            // 故意注释解锁，导致获取锁和释放锁数量不一致，则会导致死锁问题
//            lock.unlock();
        }, "A").start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "进来了");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "B").start();
    }

}
