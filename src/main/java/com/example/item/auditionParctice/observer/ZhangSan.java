package com.example.item.auditionParctice.observer;

/**
 * <b>(ZhangSan)</b>
 *
 * @author Rainy 2023-01-02 21:09:14
 * @version 1.0.0
 */
public class ZhangSan implements Credit {

    @Override
    public void notifyCredit() {
        System.out.println("zhangSan去收钱了");
    }

}
