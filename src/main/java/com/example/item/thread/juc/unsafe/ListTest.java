package com.example.item.thread.juc.unsafe;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

// java.util.ConcurrentModificationException 并发修改异常
/**
 * 多线程中list不是线程安全的，可以用下面三种方式去解决线程安全问题
 */
public class ListTest {
    // 并发下面ArrayList是不安全的
    // 解决方案：
    // 1.List<String> list = new Vector(); (线程安全)
    // 2.Collections.synchronizedList(new ArrayList<>())(线程安全)
    // 3.new CopyOnWriteArrayList<>()(写入的时候避免覆盖,是线程安全的)
    // 思考：CopyOnWriteArrayList比synchronizedArrayList的优势在哪里？
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

}
