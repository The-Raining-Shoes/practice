package com.example.item.auditionParctice.factory;

import com.example.item.auditionParctice.factory.abstroct1.HuaWeiFactory;
import com.example.item.auditionParctice.factory.abstroct1.IRouterProduct;
import com.example.item.auditionParctice.factory.abstroct1.IphoneProduct;

public class TestMain {

    public static void main(String[] args) {
        // 1.最原视创建车的方式
//        LuHuCar luHuCar = new LuHuCar();
//        luHuCar.name();
//        WuLingCar wuLingCar = new WuLingCar();
//        wuLingCar.name();
        // 2.通过简单工厂创建车的方式
//        CarInterface car1 = SimpleCarFactory.getCar("路虎");
//        car1.name();
//        CarInterface car2 = SimpleCarFactory.getCar("五菱宏光");
//        car2.name();
        // 3.通过复杂方式进行车的创建
//        WuLingFactory wuLingFactory = new WuLingFactory();
//        Car car = wuLingFactory.getCar();
//        car.name();
        // 4.通过抽象工厂来进行对象创建
        HuaWeiFactory huaWeiFactory = new HuaWeiFactory();
        IphoneProduct iphoneProduct = huaWeiFactory.iphoneProduct();
        iphoneProduct.call();
        iphoneProduct.open();
        iphoneProduct.setting();
        iphoneProduct.shutDown();
        IRouterProduct iRouterProduct = huaWeiFactory.iRouterProduct();
        iRouterProduct.changeWifi();
        iRouterProduct.connect();
        iRouterProduct.open();
        iRouterProduct.shutDown();
    }

}
