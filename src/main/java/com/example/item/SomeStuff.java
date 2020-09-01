package com.example.item;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 测试数据
 *
 * @author HXM
 * @date 2020年04月13日 9:18
 */
public class SomeStuff {

    public String getA() {
        return "123";
    }

    public static void main(String[] args) {
        String a = "10:36:52";
        String b = "11:36:56";
        String c = "12:36:52";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            System.out.println(simpleDateFormat1.format(simpleDateFormat.parse(a)));
            System.out.println(simpleDateFormat1.format(simpleDateFormat.parse(b)));
            System.out.println(simpleDateFormat.parse(a).getTime() < simpleDateFormat.parse(b).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) throws InterruptedException {
//        // 多线程的使用
//        ExecutorService exec = Executors.newFixedThreadPool(300);
//        AtomicInteger i = new AtomicInteger();
//        exec.execute(() -> {
//            if (i.get() < 1000000000) {
//                i.getAndIncrement();
//                System.out.println(i);
//            }
//        });
//        exec.shutdown();
//        while (!exec.awaitTermination(1, TimeUnit.MINUTES)) {
//            System.out.println("其他线程池没有关闭");
//        }
//    }
}