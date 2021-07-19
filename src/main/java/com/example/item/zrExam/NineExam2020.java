package com.example.item.zrExam;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

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
