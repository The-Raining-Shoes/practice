package com.example.item;

import com.example.item.domain.entity.TOrderDetail;
import com.example.item.domain.repository.res.TOrderDetailRepository;
import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseTest {

    @Setter(onMethod_ = @Autowired)
    private TOrderDetailRepository tOrderDetailRepository;

    @Test
    public void tests() {
        System.out.println(tOrderDetailRepository.getClass());
        System.out.println(1);
    }

    // 多线程跑数据demo
    @Test
    public void doJob() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (100, 100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20), new ThreadPoolExecutor.CallerRunsPolicy());
//        List<TOrderDetail> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            TOrderDetail tOrderDetail = new TOrderDetail();
            tOrderDetail.setCode("CODE" + (i + 1));
            tOrderDetail.setName("NAME" + (i + 1));
            if (executor.getActiveCount() < executor.getMaximumPoolSize()) {
                System.out.println("------------" + 1);
                executor.execute(() -> tOrderDetailRepository.save(tOrderDetail));
            } else {
                System.out.println("------------" + 2);
                tOrderDetailRepository.save(tOrderDetail);
            }

//            list.add(tOrderDetail);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
//        tOrderDetailRepository.saveAll(list);
    }

    @Test
    public void deadLock() {
        new Thread(() -> {
            try {
                System.out.println("thread1 is running");
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
