package com.example.item.threadLearning;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: HXM
 * @Date: 2020/1/3 15:27
 */
public class ThreadDemo2 {

    static Integer bz = 10;
    static Integer flag = 1;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();//被lock的包子只能同时被一个人吃
        Condition cd1 = lock.newCondition();//类似线程的等待 唤醒
        Condition cd2 = lock.newCondition();
        Condition cd3 = lock.newCondition();
        Condition cd4 = lock.newCondition();
        Condition cd5 = lock.newCondition();
        CountDownLatch cdl = new CountDownLatch(10);
        ExecutorService es = Executors.newFixedThreadPool(5);
        System.err.println("10个包子5个人吃");
        Runnable run1 = () -> {

            try {

                lock.lock();
                while (true) {
                    if (flag != 1) {
                        System.err.println("cd5休眠了");
                        cd5.await();
                    }
                    System.err.println("第1个人正在吃包子。。。");
                    Thread.sleep(5000);
                    bz--;
                    System.err.println("还剩下" + bz + "个包子");
                    flag = 2;
                    cdl.countDown();
                    cd1.signal();
                    System.err.println("cd1被唤醒了");
                }

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            lock.unlock();
        };
        Runnable run2 = () -> {
            try {

                lock.lock();
                while (true) {
                    if (flag != 2) {
                        System.err.println("cd1休眠了");
                        cd1.await();
                    }

                    System.err.println("第2个人正在吃包子。。。");
                    Thread.sleep(5000);
                    bz--;
                    System.err.println("还剩" + bz + "个包子");
                    flag = 3;
                    cdl.countDown();
                    cd2.signal();
                    System.err.println("cd2被唤醒了");
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            lock.unlock();
        };
        Runnable run3 = () -> {
            try {

                lock.lock();
                while (true) {
                    if (flag != 3) {
                        System.err.println("cd2休眠了");
                        cd2.await();
                    }

                    System.err.println("第3个人正在吃包子。。。");
                    Thread.sleep(5000);
                    bz--;
                    System.err.println("还剩" + bz + "个包子");
                    flag = 4;
                    cdl.countDown();
                    cd3.signal();
                    System.err.println("cd3被唤醒了");
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            lock.unlock();
        };
        Runnable run4 = () -> {
            try {

                lock.lock();
                while (true) {
                    if (flag != 4) {
                        System.err.println("cd3休眠了");
                        cd3.await();
                    }

                    System.err.println("第4个人正在吃包子。。。");
                    Thread.sleep(5000);
                    bz--;
                    System.err.println("还剩" + bz + "个包子");
                    flag = 5;
                    cdl.countDown();
                    cd4.signal();
                    System.err.println("cd4被唤醒了");
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            lock.unlock();
        };
        Runnable run5 = () -> {
            try {


                lock.lock();
                while (true) {
                    if (flag != 5) {
                        System.err.println("cd4休眠了");
                        cd4.await();
                    }
                    System.err.println("第5个人正在吃包子。。。");
                    Thread.sleep(5000);
                    bz--;
                    System.err.println("还剩" + bz + "个包子");
                    flag = 1;
                    cd5.signal();
                    cdl.countDown();
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            lock.unlock();
        };

        es.submit(run2);
        es.submit(run3);
        es.submit(run4);
        es.submit(run5);
        es.submit(run1);

        try {
            cdl.await();//保证所有线程都执行完成之后 主线程才会继续执行
            es.shutdownNow();//马上关闭  中断正在执行的线程
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.err.println("包子吃完了");
        System.err.println("收工。。。");

    }

}

