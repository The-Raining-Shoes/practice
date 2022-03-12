package com.example.item.thread.countMethod;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("集齐了10个线程了");
            }
        });
        for (int i = 1; i <= 10; i++) {
            final int temp = i;
            new Thread(() -> {
                    System.out.println("集齐了" + temp + "个线程了");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                }
            }).start();
        }
    }

}
