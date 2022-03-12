package com.example.item.thread.juc.unsafe;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

    public static void main(String[] args) {
        // 线程不安全
//        Map<String, Object> map = new HashMap<>();
        // 解决方法：
        // 1.ConcurrentHashMap
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                String uuid = UUID.randomUUID().toString().substring(0,5);
                map.put(Thread.currentThread().getName()+uuid
                        ,uuid);
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

}
