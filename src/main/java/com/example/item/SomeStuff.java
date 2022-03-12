package com.example.item;

import java.util.stream.LongStream;

/**
 * 测试数据
 *
 * @author MaoHao
 * @date 2020年04月13日 9:18
 */
public class SomeStuff {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        // 并发流处理计算数据
        long reduce = LongStream.range(0L, 10_000_001L).parallel().reduce(0, Long::sum);
        System.out.println(reduce);
        System.out.println(System.currentTimeMillis() - l);
    }


}