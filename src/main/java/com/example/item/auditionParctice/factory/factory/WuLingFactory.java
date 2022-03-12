package com.example.item.auditionParctice.factory.factory;

public class WuLingFactory implements CarFactory{

    @Override
    public Car getCar() {
        return new WulingCar();
    }

}
