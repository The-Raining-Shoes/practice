package com.example.item;

/**
 * 测试数据
 *
 * @author HXM
 * @date 2020年04月13日 9:18
 */
public class SomeStuff {
    public static void main(String[] args) {

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