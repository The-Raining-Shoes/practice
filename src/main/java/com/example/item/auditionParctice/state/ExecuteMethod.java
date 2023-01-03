package com.example.item.auditionParctice.state;

/**
 * <b>(ExecuteMethod)</b>
 * 状态模式
 *
 * @author Rainy 2023-01-03 12:51:37
 * @version 1.0.0
 */
public class ExecuteMethod {

    public static void main(String[] args) {
        ZhangSan zhangSan = new ZhangSan(new Happy());
        zhangSan.doWork();
        zhangSan.changeState(new Sad());
        zhangSan.doWork();
    }

}
