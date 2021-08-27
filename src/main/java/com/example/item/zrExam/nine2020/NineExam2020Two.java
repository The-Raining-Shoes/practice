package com.example.item.zrExam.nine2020;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 该类有两个静态属性的队列A_QUEUE和B_QUEUE，假设n=5则表示A_QUEUE初始化n条数据，B_QUEUE初始化2*n条数据，B_QUEUE一定是A_QUEUE的2倍。
 * 题目要求：
 * 启动2个线程分别循环的从A_QUEUE和B_QUEUE拉取数据，然后组合成一行数据输出。
 * 组合要求，用括号包裹队列中的字符串，从A_QUEUE中取1条数据，B_QUEUE中取2条数据，组合成一行输出，直到所有数据输出完为止。
 * 要求取到满足组合条件后立刻输出数据,而不是所有数据拉取完了再输出数据。
 */
public class NineExam2020Two {

    private static final int n = 5;//队列大小 A_QUEUE为n，B_QUEUE为2n
    private static final BlockingQueue<String> A_QUEUE = new ArrayBlockingQueue<>(n);
    private static final BlockingQueue<String> B_QUEUE = new ArrayBlockingQueue<>(2 * n);

    static {
        for (int i = 0; i < n; i++) {
            A_QUEUE.add("A-" + i);
        }
        for (int i = 0; i < 2 * n; i++) {
            B_QUEUE.add("B-" + i);
        }
    }

    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger(1);
        AtomicInteger b = new AtomicInteger(0);

        new Thread(() -> {
            while (true) {
                if (a.compareAndSet(1, 0)) {
                    try {
                        System.out.print("(" + A_QUEUE.take() + ")");
                        b.set(2);
                        if (A_QUEUE.size() == 0) {
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                if (b.compareAndSet(2, 0)) {
                    try {
                        System.out.print("(" + B_QUEUE.take() + ")");
                        System.out.print("(" + B_QUEUE.take() + ")");
                        System.out.println();
                        a.set(1);
                        if (B_QUEUE.size() == 0) {
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
//        try {
//            Thread.sleep(50000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}
