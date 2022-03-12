package com.example.item.thread.readWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    public static void main(String[] args) throws InterruptedException {
        MyCache myCache = new MyCache();
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> myCache.put(temp + "", temp + ""), String.valueOf(i)).start();
        }
        Thread.sleep(200);
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> myCache.get(temp + ""), String.valueOf(i)).start();
        }
    }


}

class MyCache {

    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    volatile Map<String, String> map = new HashMap<>();

    public void put(String key, String value) {
        reentrantReadWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "存放" + key + "开始");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "存放" + key + "结束");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        reentrantReadWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取" + key + "开始");
            String s = map.get(key);
            System.out.println(Thread.currentThread().getName() + "获取到了" + s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

}