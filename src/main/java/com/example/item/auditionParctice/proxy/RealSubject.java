package com.example.item.auditionParctice.proxy;

/**
 * <b>(RealSubject)</b>
 *
 * @author Rainy 2023-01-03 13:29:01
 * @version 1.0.0
 */
public class RealSubject implements Subject {

    @Override
    public void doWork() {
        System.out.println("真实的使用场景类");
    }

}
