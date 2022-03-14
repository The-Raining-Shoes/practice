package com.example.item.thread.cas.myLock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自定义自旋锁
 */
public class MyLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        // 先进入的线程将数据修改成锁对象，后面进来的线程就会一直while循环等待
        while (!atomicReference.compareAndSet(null, thread)) {
            System.out.println(thread.getName() + "进入了while循环");
        }
        System.out.println(thread.getName() + "----拿到锁");

    }

    public void unlockMyLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "----放弃锁");
        atomicReference.compareAndSet(thread, null);
    }


}
