package com.example.item.thread.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
        test4();
    }

    /**
     * add、remove、element是一组，会抛出异常 add添加操作、remove队列移除操作、element检查队列首位元素操作
     */
    public static void test1() {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.add(1);
        arrayBlockingQueue.add(2);
        arrayBlockingQueue.add(3);
        System.out.println("==============");
        System.out.println(arrayBlockingQueue.element());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        // 多打印抛异常
//        System.out.println(arrayBlockingQueue.remove());
    }

    /**
     * offer、poll、peek是一组，有返回值不抛出异常，offer=添加，poll=取出、peek=检查首尾元素
     */
    public static void test2() {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.offer(1);
        arrayBlockingQueue.offer(2);
        arrayBlockingQueue.offer(3);
        System.out.println("============");
        System.out.println(arrayBlockingQueue.peek());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        // 多打印不会抛出异常会返回null值
        System.out.println(arrayBlockingQueue.poll());
    }

    /**
     * put、take是一类，不会抛出异常、不会返回空值，但是会阻塞队列（会一直阻塞直到处理完成）
     *
     * @throws InterruptedException 异常处理
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.put(1);
        arrayBlockingQueue.put(2);
        arrayBlockingQueue.put(3);
        System.out.println("============");
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        // 多打印不会抛出异常会返回null值
        System.out.println(arrayBlockingQueue.take());
    }

    /**
     * offer和poll可以添加超时时间，即添加等待时间、取出等待时间，如果达到等待时间仍未处理成功，则继续执行下面操作
     * @throws InterruptedException 异常处理
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.offer(4);
        arrayBlockingQueue.offer(5);
        arrayBlockingQueue.offer(6);
        // 添加两秒，如果添加不进去就继续往后面执行
        arrayBlockingQueue.offer(1, 2, TimeUnit.SECONDS);
        System.out.println("============");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        // 等待两秒就会自动退出
        System.out.println(arrayBlockingQueue.poll(2,TimeUnit.SECONDS));
    }


}
