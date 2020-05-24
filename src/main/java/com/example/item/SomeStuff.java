package com.example.item;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 测试数据
 *
 * @author HXM
 * @date 2020年04月13日 9:18
 */
public class SomeStuff {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Stream.of("13", "张三丰", "测试组", "是").filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).distinct().toArray()).substring(1, Arrays.toString(Stream.of("13", "张三丰", "测试组", "是").filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).distinct().toArray()).length() - 1));
    }
}