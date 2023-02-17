package com.example.item.thread;

import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <b>(Test)</b>
 *
 * @author Rainy 2023-02-01 12:55:22
 * @version 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        demo a = new demo();
        executorService.submit(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    a.add();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "a");
        executorService.submit(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    a.devide();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "b");
        try {
            executorService.shutdown();
            System.out.println(executorService.awaitTermination(10, TimeUnit.MINUTES));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

class demo {

    List<String> list = new Vector<>();

    public synchronized void add() throws InterruptedException {
        while (list.size() != 0) {
            this.wait();
        }
        final String s = UUID.randomUUID().toString();
        System.out.println("生产" + s);
        list.add(s);
        Thread.sleep(100);
        this.notifyAll();
    }

    public synchronized void devide() throws InterruptedException {
        while (list.size() == 0) {
            this.wait();
        }
        System.out.println("消费" + list);
        list.remove(0);
        Thread.sleep(100);
        this.notifyAll();
    }

}