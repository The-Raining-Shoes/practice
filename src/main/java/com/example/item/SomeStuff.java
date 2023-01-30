package com.example.item;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <b>(SomeStuff)</b>
 *
 * @author Rainy 2023-01-03 13:02:33
 * @version 1.0.0
 */
public class SomeStuff {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<CompletableFuture<Integer>> collect = Stream.of(1, 2, 3).map(e -> CompletableFuture.completedFuture(e)
                .thenApplyAsync(as -> as)).collect(Collectors.toList());
    }

}
