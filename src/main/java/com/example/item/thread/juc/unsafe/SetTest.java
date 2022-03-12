package com.example.item.thread.juc.unsafe;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 关于多线程中线程安全的集合（1.CopyOnWriteArraySet 2.Collections.synchronized）
 */
public class SetTest {

    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();(线程不安全)
        // 线程安全1
        Set<String> set = new CopyOnWriteArraySet<>();
        // Collections.synchronizedSet(new HashSet<String>()); (线程安全2)
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, "" + i).start();
        }
    }

}
