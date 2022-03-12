package com.example.item.thread.threadPool;

import com.example.item.SomeStuff;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NewFixedThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Object> submit = executorService.submit(SomeStuff::new);
        System.out.println(submit.get());
    }

}
