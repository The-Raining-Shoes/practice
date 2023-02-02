package com.example.item.thread.cas;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 带版本号的原子变量
 */
public class ReferenceTest {

    public static void main(String[] args) {
        // 注意如果引用泛型是一个包装类，那么可能会出现引用问题
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1, 1);
        // 捣乱的线程
        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(1, 3, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("A->" + atomicStampedReference.getStamp());
            System.out.println(atomicStampedReference.compareAndSet(3, 1, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("A->" + atomicStampedReference.getStamp());
        }, "A").start();
        // 正常的线程
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("B获得锁" + stamp);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(1, 6666, stamp, stamp + 1));
            System.out.println("B->" + atomicStampedReference.getStamp());
        }, "B").start();
    }

}
