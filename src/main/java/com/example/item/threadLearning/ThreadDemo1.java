package com.example.item.threadLearning;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: HXM
 * @Date: 2019/12/27 10:39
 */
public class ThreadDemo1 {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (5, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 100; i++) {
            executor.execute(ThreadDemo1::func);
        }
    }

    public static void func() {
        System.err.println("方法调用开始。。。。。。");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.err.println("方法调用结束。。。。。。");
    }

}