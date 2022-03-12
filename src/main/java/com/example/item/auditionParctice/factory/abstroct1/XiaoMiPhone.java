package com.example.item.auditionParctice.factory.abstroct1;

public class XiaoMiPhone implements IphoneProduct{

    @Override
    public void call() {
        System.out.println("小米电话call");
    }

    @Override
    public void shutDown() {
        System.out.println("小米电话shutDown");
    }

    @Override
    public void open() {
        System.out.println("小米电话open");
    }

    @Override
    public void setting() {
        System.out.println("小米电话setting");
    }

}
