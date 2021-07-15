package com.example.item.threadLearning.cyclicBarrier;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadCountNum {

    private static final Random random = new Random();

    public static void main(String[] args) {
        //数组大小
        int size = 50000;
        //定义数组
        int[] numbers = new int[size];
        //随机初始化数组
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100);
        }

        //单线程计算结果
        long sum = 0L;
        for (int i = 0; i < size; i++) {
            sum += numbers[i];
        }
        System.out.println("单线程计算结果：" + sum);

        //多线程计算结果
        //定义长度为5的数组保存每个线程的计算结果
        final int[] results = new int[5];
        //定义一个大小为5的循环栅栏，传入的runnable是当barrier触发时执行
        CyclicBarrier barrier = new CyclicBarrier(5, () -> {
            long sums = 0;
            for (int i = 0; i < 5; i++) {
                sums += results[i];
            }
            System.out.println("多线程计算结果：" + sums);
        });
        //子数组长度
        int length = 10000;
        //定义五个线程去计算
        for (int i = 0; i < 5; i++) {
            //定义子数组
            int[] subNumbers = Arrays.copyOfRange(numbers, (i * length), ((i + 1) * length));
            System.out.println(Arrays.toString(subNumbers));
            //盛放计算结果
            int finalI = i;
            new Thread(() -> {
                for (int subNumber : subNumbers) {
                    results[finalI] += subNumber;
                }
                //等待其他线程进行计算
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
            System.out.println(barrier.getNumberWaiting());
        }
        System.out.println(barrier.getNumberWaiting());
    }

}
