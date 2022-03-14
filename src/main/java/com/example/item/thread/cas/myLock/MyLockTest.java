package com.example.item.thread.cas.myLock;

/**
 * 自旋锁测试
 */
public class MyLockTest {

    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        new Thread(() -> {
            myLock.myLock();
            try {
                System.out.println("A线程拿到了锁,睡五秒");
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                myLock.unlockMyLock();
            }
        }, "A").start();
        // B线程进入发现A线程已经拿到了线程锁，所以执行会一直进入while循环
        new Thread(() -> {
            myLock.myLock();
            try {
                System.out.println("B线程拿到了锁");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                myLock.unlockMyLock();
            }
        }, "B").start();
    }

}
