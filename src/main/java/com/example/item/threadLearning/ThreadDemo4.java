package com.example.item.threadLearning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author HXM
 * @date 2020年09月01日 15:18
 */
public class ThreadDemo4 {
    static Integer flag = 1;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition cd1 = lock.newCondition();
        Condition cd2 = lock.newCondition();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Runnable run1 = () -> {
            lock.lock();
            try {
                while (flag != 1) {
                    cd1.await();
                }
                System.out.println("cd1复活了");
                System.out.println(1);
                flag = 2;
//                cd2.signal();
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable run2 = () -> {
            lock.lock();
            try {
                while (flag != 2) {
                    cd2.await();
                }
                System.out.println("cd2复活了");
                System.out.println(2);
                flag = 1;
//                cd1.signal();
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executorService.submit(run2);
        executorService.submit(run1);
        executorService.shutdown();
        while (true) {
            try {
                if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("其他线程池没有关闭");
        }
    }
}
