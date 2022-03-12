package com.example.item.thread.countMethod;

import java.util.concurrent.CountDownLatch;

/**
 * countDownLatch简单的使用
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i <= 6; i++) {
            System.out.println(i + "出门了");
            new Thread(countDownLatch::countDown, String.valueOf(i)).start();
        }
        try {
            // 等待计数器归0的时候，才会执行下面的逻辑，否则阻塞线程
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("close door");
    }

}
