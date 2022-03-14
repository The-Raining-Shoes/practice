package com.example.item.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        // 捣乱的线程（将数据从1更改成3 又从3更改成1）
        atomicInteger.compareAndSet(1,3);
        atomicInteger.compareAndSet(3,1);
        // 正常线程
        atomicInteger.compareAndSet(1,6666);
        System.out.println(atomicInteger.get());
    }

}
