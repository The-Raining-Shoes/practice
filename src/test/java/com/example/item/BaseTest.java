package com.example.item;

import com.example.item.auditionParctice.strategyAndFactory.StrategyFactory;
import com.example.item.auditionParctice.strategyAndFactory.StrategyInterface;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class BaseTest {

    private final Cache<String, String> autoCache = Caffeine.newBuilder()
            // 设置最后一次写入或访问后经过固定时间过期
            .expireAfterWrite(20, TimeUnit.MINUTES)
            // 初始的缓存空间大小
            .initialCapacity(10000)
            // 缓存的最大条数
            .maximumSize(10000 * 50)
            .refreshAfterWrite(1, TimeUnit.MINUTES)
            .build(this::getCache);

    private final Cache<String, String> initCache = Caffeine.newBuilder()
            // 设置最后一次写入或访问后经过固定时间过期
            .expireAfterWrite(1, TimeUnit.HOURS)
            // 初始的缓存空间大小
            .initialCapacity(10000)
            // 缓存的最大条数
            .maximumSize(10000 * 50)
            .build();

    @Test
    public void testAutoCache() {
        System.out.println(autoCache.get("123", this::getCache));
        System.out.println(autoCache.get("123", this::getCache));
    }

    @Test
    public void testInitCache() {
        String name = "123";
        System.out.println(getInitCache(name));
        System.out.println(getInitCache(name));
    }

    @Test
    public void testAudition() {
        String name = "StrategyImplMao";
        final StrategyInterface strategy = StrategyFactory.getStrategy(name);
        strategy.AAA("测试");
        System.out.println(StrategyFactory.strategyFactory);
    }

    private String getInitCache(String code) {
        return initCache.get(code, k -> {
            System.out.println("方法进来了");
            System.out.println(code);
            System.out.println(k);
            return k + "test";
        });
    }

    private String getCache(String key) {
        System.out.println("方法进来了");
        return key;
    }

    // 多线程跑数据demo
//    @Test
//    public void doJob() {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor
//                (100, 100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20), new ThreadPoolExecutor.CallerRunsPolicy());
////        List<TOrderDetail> list = new ArrayList<>();
//        for (int i = 0; i < 1000000; i++) {
//            TOrderDetail tOrderDetail = new TOrderDetail();
//            tOrderDetail.setCode("CODE" + (i + 1));
//            tOrderDetail.setName("NAME" + (i + 1));
//            if (executor.getActiveCount() < executor.getMaximumPoolSize()) {
//                System.out.println("------------" + 1);
//                executor.execute(() -> tOrderDetailRepository.save(tOrderDetail));
//            } else {
//                System.out.println("------------" + 2);
//                tOrderDetailRepository.save(tOrderDetail);
//            }
//
////            list.add(tOrderDetail);
//        }
//        executor.shutdown();
//        while (!executor.isTerminated()) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
////        tOrderDetailRepository.saveAll(list);
//    }

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                System.out.println("thread1 is running");
                synchronized (BaseTest.class) {
                    System.out.println("thread is block obj2");
                    Thread.sleep(100);
                    synchronized (Object.class) {
                        System.out.println("thread1 is over");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("thread2 is running");
                synchronized (Object.class) {
                    System.out.println("thread is block obj1");
                    Thread.sleep(100);
                    synchronized (BaseTest.class) {
                        System.out.println("thread2 is over");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Test
    public void deadLock() {
        new Thread(() -> {
            try {
                System.out.println("thread2 is running");
                synchronized (BaseTest.class) {
                    System.out.println("thread is block obj1");

                    Thread.sleep(1000);
                    synchronized (Object.class) {
                        System.out.println("thread is block ojb2");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("thread1 is running");
                synchronized (Object.class) {
                    System.out.println("thread is block obj1");

                    Thread.sleep(1000);
                    synchronized (BaseTest.class) {
                        System.out.println("thread is block ojb2");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
