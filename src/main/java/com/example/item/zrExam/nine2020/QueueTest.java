package com.example.item.zrExam.nine2020;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class QueueTest {
    private static final int n = 5;//队列大小 A_QUEUE为n，B_QUEUE为2n
    private static final BlockingQueue<String> A_QUEUE = new ArrayBlockingQueue<>(n);
    private static final BlockingQueue<String> B_QUEUE = new ArrayBlockingQueue<>(2 * n);
    private static final Vector<String> temp = new Vector<>();
    private static final Semaphore aSem = new Semaphore(1);
    private static final Semaphore bSem = new Semaphore(1);
    private static final Semaphore cSem = new Semaphore(0);

    static {
        for (int i = 0; i < n; i++) {
            A_QUEUE.add("A-" + i);
        }
        for (int i = 0; i < 2 * n; i++) {
            B_QUEUE.add("B-" + i);
        }
    }

    @Test
    public void test() {
        new Thread(new MyThread1()).start();
        new Thread(new MyThread2()).start();
        for (int i = 0; i < n; i++) {
            try {
                cSem.acquire(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("(" + String.join(")(", temp) + ")");
            temp.clear();
            aSem.release(1);
            bSem.release(1);
        }
    }

    static class MyThread1 implements Runnable {
        @SneakyThrows
        public void run() {
            for (int i = 0; i < n; i++) {
                aSem.acquire(1);
                temp.add(A_QUEUE.poll());
                cSem.release(1);
            }
        }
    }

    static class MyThread2 implements Runnable {
        @SneakyThrows
        public void run() {
            for (int i = 0; i < n; i++) {
                bSem.acquire(1);
                temp.add(B_QUEUE.poll());
                temp.add(B_QUEUE.poll());
                cSem.release(1);
            }
        }
    }

}
