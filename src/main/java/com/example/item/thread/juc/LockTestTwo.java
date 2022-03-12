package com.example.item.thread.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock锁进行线程的精确唤醒
 */
public class LockTestTwo {

    public static void main(String[] args) {
        B b = new B();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                b.a();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                b.b();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                b.c();
            }
        },"C").start();
    }


}

class B{

    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    private int num = 1;

    public void a(){
        lock.lock();
        try {
            while (num!=1){
                conditionA.await();
            }
            num = 2;
            conditionB.signal();
            System.out.println(Thread.currentThread().getName()+"唤醒了"+"B");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void b(){
        lock.lock();
        try {
            while (num!=2){
                conditionB.await();
            }
            num = 3;
            conditionC.signal();
            System.out.println(Thread.currentThread().getName()+"唤醒了"+"C");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void c(){
        lock.lock();
        try {
            while (num!=3){
                conditionC.await();
            }
            num = 1;
            conditionA.signal();
            System.out.println(Thread.currentThread().getName()+"唤醒了"+"A");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}