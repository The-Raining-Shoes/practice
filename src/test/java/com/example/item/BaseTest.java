package com.example.item;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BaseTest.class})
public class BaseTest {

    @Test
    public void doJob() {
        System.out.println(BigInteger.valueOf(0));
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
