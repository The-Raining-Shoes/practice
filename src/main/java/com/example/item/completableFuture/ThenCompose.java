package com.example.item.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <b>(Test2)</b>
 *
 * @author Rainy 2023-01-29 14:45:42
 * @version 1.0.0
 */
public class ThenCompose {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        User user = new User(1, "毛豪", "测试");
        Dept dept = new Dept("code", "name");
        final CompletableFuture<User> deptCompletableFuture = CompletableFuture.supplyAsync(() -> dept).thenCompose(e -> CompletableFuture.supplyAsync(() -> {
            user.setName(e.getName());
            user.setCode(e.getCode());
            return user;
        }));
        System.out.println(deptCompletableFuture.get());
    }

}
