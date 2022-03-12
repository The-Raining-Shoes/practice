package com.example.item.thread.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 通过thread如何直接调用callable
        FutureTask<String> stringFutureTask = new FutureTask<>(new MyThread());
        new Thread(stringFutureTask, "test1").start();
        new Thread(stringFutureTask, "test2").start();
        String result = stringFutureTask.get();
        System.out.println(result);
    }

}

class MyThread implements Callable<String> {

    @Override
    public String call() {
        System.out.println(Thread.currentThread().getName());
        return "123";
    }

}