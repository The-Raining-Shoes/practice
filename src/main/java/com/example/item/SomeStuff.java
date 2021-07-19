package com.example.item;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 测试数据
 *
 * @author MaoHao
 * @date 2020年04月13日 9:18
 */
@Slf4j
public class SomeStuff {

    private static final int n = 5;//队列大小 A_QUEUE为n，B_QUEUE为2n
    private static final BlockingQueue<String> A_QUEUE = new ArrayBlockingQueue<>(n);
    private static final BlockingQueue<String> B_QUEUE = new ArrayBlockingQueue<>(2*n);
    static {
        for (int i = 0; i < n; i++) {
            A_QUEUE.add("A-" + i);
        }
        for (int i = 0; i < 2 * n; i++) {
            B_QUEUE.add("B-" + i);
        }
    }

    public static void main(String[] args) {
        System.out.println(A_QUEUE);
        System.out.println(B_QUEUE);

    }

}