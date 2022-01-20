package com.example.item;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

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

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            for (String string : list) {
                System.out.println(string);
            }
        });
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final int count = i;
            new Thread(() -> {
                Thread.currentThread().setName("测试" + count);
                list.add(Thread.currentThread().getName());
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
            System.out.println(cyclicBarrier.getNumberWaiting());
        }
    }

}