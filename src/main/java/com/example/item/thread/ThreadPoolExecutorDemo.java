package com.example.item.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 60L, TimeUnit.SECONDS
                , new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 100; i++) {
            final int key = i;
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "key" + key);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolExecutor.shutdown();
        while (true) {
            if (threadPoolExecutor.isTerminated()) {
                break;
            }
        }

    }

}
