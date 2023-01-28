package com.example.item.auditionParctice.flyWeight;

/**
 * <b>(ExecuteMethod)</b>
 * 享元模式
 *
 * @author Rainy 2023-01-05 13:18:13
 * @version 1.0.0
 */
public class ExecuteMethod {

    public static void main(String[] args) {
        Bike bike1 = FlyFactory.getFlyFactory().getBike();
        bike1.ride("rainy");
//        bike1.back();
        Bike bike2 = FlyFactory.getFlyFactory().getBike();
        bike2.ride("测试1");
        bike2.back();
        Bike bike3 = FlyFactory.getFlyFactory().getBike();
        bike3.ride("测试2");
        bike3.back();
    }

}
