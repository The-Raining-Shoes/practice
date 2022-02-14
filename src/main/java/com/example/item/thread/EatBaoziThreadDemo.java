package com.example.item.thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程吃包子测试
 */
public class EatBaoziThreadDemo {

    static int baoZi = 5;
    static int i = 1;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        Condition condition4 = lock.newCondition();
        Condition condition5 = lock.newCondition();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 5, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        Runnable run1 = () -> {
            lock.lock();
            System.out.println("线程1拿到锁");
            while (true) {
                System.out.println(i);
                if (i != 1) {
                    try {
                        System.out.println("线程1准备休眠了。。。");
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i = 2;
                System.out.println("线程1在吃包子");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baoZi--;
                System.out.println("还剩下" + baoZi + "个包子");
                countDownLatch.countDown();
                condition2.signal();
            }
        };
        Runnable run2 = () -> {
            lock.lock();
            System.out.println("线程2拿到锁");
            while (true) {
                System.out.println(i);
                if (i != 2) {
                    try {
                        System.out.println("线程2准备休眠了。。。");
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i = 3;
                System.out.println("线程2在吃包子");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baoZi--;
                System.out.println("还剩下" + baoZi + "个包子");
                countDownLatch.countDown();
                condition3.signal();
            }
        };
        Runnable run3 = () -> {
            lock.lock();
            System.out.println("线程3拿到锁");
            while (true) {
                System.out.println(i);
                if (i != 3) {
                    try {
                        System.out.println("线程3准备休眠了。。。");
                        condition3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 指定下一个吃包子的人
                i = 4;
                System.out.println("线程3在吃包子");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baoZi--;
                System.out.println("还剩下" + baoZi + "个包子");
                countDownLatch.countDown();
                condition4.signal();
            }
        };
        Runnable run4 = () -> {
            lock.lock();
            System.out.println("线程4拿到锁");
            while (true) {
                System.out.println(i);
                if (i != 4) {
                    try {
                        System.out.println("线程4准备休眠了。。。");
                        condition4.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 指定下一个吃包子的人
                i = 5;
                System.out.println("线程4在吃包子");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baoZi--;
                System.out.println("还剩下" + baoZi + "个包子");
                countDownLatch.countDown();
                condition5.signal();
            }
        };
        Runnable run5 = () -> {
            lock.lock();
            System.out.println("线程5拿到锁");
            while (true) {
                System.out.println(i);
                if (i != 5) {
                    try {
                        System.out.println("线程5准备休眠了。。。");
                        condition5.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 指定下一个吃包子的人
                i = 1;
                System.out.println("线程5正在吃包子");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                baoZi--;
                System.out.println("还剩下" + baoZi + "个包子");
                countDownLatch.countDown();
//                condition1.signal();
            }
        };
        System.out.println("5个包子5个人吃");
        System.out.println("预备开始！！！");
        threadPoolExecutor.execute(run1);
        threadPoolExecutor.execute(run2);
        threadPoolExecutor.execute(run3);
        threadPoolExecutor.execute(run4);
        threadPoolExecutor.execute(run5);
        try {
            countDownLatch.await();
            System.out.println("===========");
            threadPoolExecutor.shutdownNow();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.err.println("收工。。。");
    }

}
