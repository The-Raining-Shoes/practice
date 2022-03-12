package com.example.item.auditionParctice.factory.abstroct1;

public class XiaoMiRoute implements IRouterProduct{

    @Override
    public void changeWifi() {
        System.out.println("小米路由器changeWifi");
    }

    @Override
    public void open() {
        System.out.println("小米路由器open");
    }

    @Override
    public void shutDown() {
        System.out.println("小米路由器shutdown");
    }

    @Override
    public void connect() {
        System.out.println("小米路由器connect");
    }
    
}
