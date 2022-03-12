package com.example.item.thread.juc;

/**
 * 生产者消费者问题，wait()和notify()来实现线程之间的简单通讯
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        A a = new A();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    a.incr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    a.decr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    a.incr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    a.decr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "D").start();
    }

}

class A {

    private Integer num = 1;

    public synchronized void incr() throws InterruptedException {
        while (num != 1) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "已完成+1操作num:" + num);
        this.notifyAll();
    }

    public synchronized void decr() throws InterruptedException {
        while (num == 1) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "已完成-1操作num:" + num);
        this.notifyAll();
    }

}