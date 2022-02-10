package com.example.item.thread;

public class WaitNotifyDemo {

    static volatile boolean a = false;

    public static void main(String[] args) {
        Object object = new Object();
        new Thread(() -> {
            synchronized (object) {
                String name = Thread.currentThread().getName();
                System.out.println("线程" + name + "进来了");
                try {
                    System.out.println("线程" + name + "睡了。。。。");
                    Thread.sleep(4000);
                    System.out.println("线程" + name + "开始释放锁。。。。");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + name + "启动了");
                while (true) {
                    if (a) {
                        System.out.println(name + "执行完成");
                        break;
                    }
                }
            }
        }, "线程1").start();
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println("线程" + name + "启动了");
            synchronized (object) {
                System.out.println("线程" + name + "拿到锁了");
                while (true) {
                    if (!a) {
                        a = true;
                        System.out.println(name + "执行完成");
                        object.notify();
                        break;
                    }
                }
            }
        }, "线程2").start();
    }

}
