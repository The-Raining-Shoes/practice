package com.example.item.zrExam.nine2020;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * 该类有两个静态属性的队列A_QUEUE和B_QUEUE，假设n=5则表示A_QUEUE初始化n条数据，B_QUEUE初始化2*n条数据，B_QUEUE一定是A_QUEUE的2倍。
 * 题目要求：
 * 启动2个线程分别循环的从A_QUEUE和B_QUEUE拉取数据，然后组合成一行数据输出。
 * 组合要求，用括号包裹队列中的字符串，从A_QUEUE中取1条数据，B_QUEUE中取2条数据，组合成一行输出，直到所有数据输出完为止。
 * 要求取到满足组合条件后立刻输出数据,而不是所有数据拉取完了再输出数据。
 */
public class NineExam2020 {

    private static final Semaphore semaphore1 = new Semaphore(1);
    private static final Semaphore semaphore2 = new Semaphore(1);
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
        String[] a = new String[3];
        int aSize = A_QUEUE.size();
        int bSize = B_QUEUE.size();
        new Thread(() -> {
            for (int i = 0; i < aSize; i++) {
                try {
                    semaphore1.acquire(1);
                    a[0] = "(" + A_QUEUE.take() + ")";
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < bSize / 2; i++) {
                try {
                    semaphore2.acquire(1);
                    a[1] = "(" + B_QUEUE.take() + ")";
                    a[2] = "(" + B_QUEUE.take() + ")";
                    Thread.sleep(100);
                    for (String str : a) {
                        System.out.print(str);
                    }
                    System.out.println();
                    semaphore1.release(1);
                    semaphore2.release(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
