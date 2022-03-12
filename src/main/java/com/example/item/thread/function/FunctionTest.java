package com.example.item.thread.function;

import java.util.function.Function;

/**
 * function函式接口编程
 * 返回型接口
 */
public class FunctionTest {

    public static void main(String[] args) {
        Function<String, Object> function = (str) -> str + "Test";
        System.out.println(function.apply("测试数据"));
    }

}
