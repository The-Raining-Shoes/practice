package com.example.item.thread.threadPool;

import java.util.concurrent.*;

public class NewFixedThreadPool implements Callable<Integer> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> submit = executorService.submit(new NewFixedThreadPool());
        System.out.println(submit.get());
    }

    @Override
    public Integer call() {
        return null;
    }

}
