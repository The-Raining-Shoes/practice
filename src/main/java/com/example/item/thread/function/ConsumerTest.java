package com.example.item.thread.function;

import java.util.function.Consumer;

/**
 * consumer消费型接口，只有输入，没有返回值
 */
public class ConsumerTest {

    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer.accept("测试东西");
    }

}
