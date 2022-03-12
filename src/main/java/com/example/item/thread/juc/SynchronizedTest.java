package com.example.item.thread.juc;

/**
 * synchronized关键字的简单使用
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                tickets.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                tickets.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                tickets.sale();
            }
        }, "C").start();
    }

}

class Tickets {

    private int num = 30;

    public synchronized void sale() {
        if (num >0) {
            System.out.println(Thread.currentThread().getName() + "卖出了" + num + "张票,还剩余" + --num + "张票");
        }
    }

}