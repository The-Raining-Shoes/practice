package com.example.item.thread.blockQueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列，添加了一个数据过后，只能等待另外一个线程来取出这个数据，不然队列就会一直阻塞
 */
public class SynchronizedBlockingQueue {

    public static void main(String[] args) {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                synchronousQueue.put(1);
                System.out.println(Thread.currentThread().getName()+"put1");
                synchronousQueue.put(2);
                System.out.println(Thread.currentThread().getName()+"put2");
                synchronousQueue.put(3);
                System.out.println(Thread.currentThread().getName()+"put3");
            }catch (Exception e){
                e.printStackTrace();
            }
        },"A").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"take1="+synchronousQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"take2="+synchronousQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+"take3="+synchronousQueue.take());
            }catch (Exception e){
                e.printStackTrace();
            }
        },"B").start();
    }

}
