package com.example.item.thread.folkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * 求和计算任务
 * 1.直接计算
 * 2。forkJoin方法分流计算
 * 3.longStream并行流计算
 */
public class FolkJoinTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1();
//        test2();
        test3();
    }

    /**
     * 直接循环计算（最基础的方式）
     */
    private static void test1() {
        long startTime = System.currentTimeMillis();
        long num = 0L;
        for (int i = 1; i <= 10_0000_0000; i++) {
            num += i;
        }
        System.out.println("sum=" + num + " 使用了时间" + (System.currentTimeMillis() - startTime));
    }

    private static void test2() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(0L, 10_0000_0000L);
        final ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoinDemo);
        System.out.println("sum=" + submit.get() + "使用时间：" + (System.currentTimeMillis() - startTime));
    }

    public static void test3() {
        long startTime = System.currentTimeMillis();
        final long reduce = LongStream.rangeClosed(0, 10_0000_0000).parallel().reduce(0, Long::sum);
        System.out.println("sum=" + reduce + " 使用了时间" + (System.currentTimeMillis() - startTime));
    }

}
