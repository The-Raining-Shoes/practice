package com.example.item.completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * <b>(Test1)</b>
 * 同步收集异步信息结果
 *
 * @author Rainy 2023-01-29 14:44:14
 * @version 1.0.0
 */
public class CollectSyncDataCompletable {

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        List<CompletableFuture<String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            CompletableFuture.supplyAsync(() -> taskString("test_" + finalI));
            list.add(CompletableFuture.supplyAsync(() -> taskString("test_" + finalI)));
        }
        final CompletableFuture<Void> allOf = CompletableFuture.allOf(list.toArray(new CompletableFuture[0]));
        allOf.join();
        allOf.thenApply(v -> new ArrayList<>(list)).whenComplete((a, b) -> {
            list.forEach(cf -> result.add(cf.getNow(null)));
        });
        System.out.println(result);
    }

    static String taskString(String testCode) {
        System.out.println(Thread.currentThread().getName() + "进来了");
        System.out.println(Thread.currentThread().getName() + "执行结束");
        return testCode.concat("_Code");
    }

}
