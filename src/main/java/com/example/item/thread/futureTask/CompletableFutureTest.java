package com.example.item.thread.futureTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步调用：CompletableFuture
 * 异步执行
 * 成功回调
 * 失败回调
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        // 1.没有返回值的异步回调
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()));
//        Thread.sleep(1000);
//        System.out.println(111);
//        future.get();
        // 2.有返回值的异步调用
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            int i = (10 / 0);
            return 1024;
        });
        // integerCompletableFuture获取结果的两种方式
        // 1.直接获取
        System.out.println(integerCompletableFuture.get());
        // 2.通过函数判断获取(可以针对异常进行处理)
        System.out.println(integerCompletableFuture.whenComplete((t, u) -> {
            System.out.println("t->" + t);
            System.out.println("u->" + u);
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 404;
        }).get());
    }

}
