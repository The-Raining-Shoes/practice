package com.example.item.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * <b>(Combine)</b>
 *
 * @author Rainy 2023-01-29 14:58:17
 * @version 1.0.0
 */
public class Combine {

    public static void main(String[] args) {
        CompletionStage<Dept> dept = CompletableFuture.completedFuture(new Dept("1", "2"));
        CompletionStage<User> user = CompletableFuture.completedFuture(new User(1, "3", "4"));
        dept.thenCombine(user, (dept1, user1) -> {
            user1.setCode("11111111");
            return user1;
        }).whenComplete((a, b) -> System.out.println(a));
    }

}
