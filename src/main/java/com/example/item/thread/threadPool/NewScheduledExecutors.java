package com.example.item.thread.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledExecutors {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5, Executors.defaultThreadFactory());
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            System.out.println(1);
//            try {
//                Thread.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },1,3, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println(1);
            try {
                Thread.sleep(4000);
                System.out.println("任务结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1,3, TimeUnit.SECONDS);
    }

}
