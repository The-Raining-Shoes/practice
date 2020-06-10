package com.example.item;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试数据
 *
 * @author HXM
 * @date 2020年04月13日 9:18
 */
@Component
public class SomeStuff {
    public static void main(String[] args) {
        // 多线程的使用
        ExecutorService exec = Executors.newFixedThreadPool(300);
        exec.execute(() -> {

        });
    }
}