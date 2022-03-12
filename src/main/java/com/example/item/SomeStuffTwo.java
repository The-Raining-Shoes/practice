package com.example.item;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;

@Component
public class SomeStuffTwo {

    public static void main(String[] args) {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast("测试1");
        arrayDeque.addLast("测试2");
        arrayDeque.addLast("测试3");
        arrayDeque.addLast("测试4");
        arrayDeque.addFirst("测试5");
        System.out.println(arrayDeque);
    }

    @Bean
    public SomeStuff getSomeStuff() {
        return new SomeStuff();
    }

}
