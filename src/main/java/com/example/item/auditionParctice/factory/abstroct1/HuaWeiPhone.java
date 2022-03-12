package com.example.item.auditionParctice.factory.abstroct1;

public class HuaWeiPhone implements IphoneProduct{

    @Override
    public void call() {
        System.out.println("华为电话call");
    }

    @Override
    public void shutDown() {
        System.out.println("华为电话shutDown");
    }

    @Override
    public void open() {
        System.out.println("华为电话open");
    }

    @Override
    public void setting() {
        System.out.println("华为电话setting");
    }

}
