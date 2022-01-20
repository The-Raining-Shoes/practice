package com.example.item;

import lombok.Data;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试数据
 *
 * @author MaoHao
 * @date 2020年04月13日 9:18
 */
@Data
public class SomeStuff {

    private final String name = "test";
    private Integer code;

    // 題目1 多线程计算数量
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,60,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());
        int[] numbers = new int[1600];
        for(int i=0;i<1600;i++){
            numbers[i] = i;
        }
        int length = 100;
        for (int i = 0; i < 16; i++) {
            // 定义子数组
            int[] subNumbers = Arrays.copyOfRange(numbers, (i * length), ((i + 1) * length));
            executor.execute(() -> {
                for (int subNumber : subNumbers) {
                    System.out.println(Thread.currentThread().getName()+"key"+subNumber);
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
        while (true){
            if(executor.isTerminated()){
                break;
            }
        }
    }

}