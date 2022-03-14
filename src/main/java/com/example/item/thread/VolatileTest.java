package com.example.item.thread;

import java.util.HashMap;
import java.util.Map;

public class VolatileTest {

    public static Map<String, Object> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 10_000_00; i++) {
                map.put(Thread.currentThread().getName() + i, i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10_000_00; i++) {
                map.put(Thread.currentThread().getName() + i, i);
            }
        }).start();
        Thread.sleep(2000);
        map.forEach((a, b) -> {
            System.out.println("key" + a + ":value" + b);
        });
        System.out.println(map.size());
    }

}
