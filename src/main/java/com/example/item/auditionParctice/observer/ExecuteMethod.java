package com.example.item.auditionParctice.observer;

/**
 * <b>(ExecuteMethod)</b>
 * 观察者模式
 *
 * @author Rainy 2023-01-02 21:11:58
 * @version 1.0.0
 */
public class ExecuteMethod {

    public static void main(String[] args) {
        Credit zhangSan = new ZhangSan();
        Debit lisi = new Lisi();
        lisi.borrow(zhangSan);
        lisi.notifyCredits();
    }

}
