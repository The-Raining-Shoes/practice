package com.example.item.auditionParctice.factory.simpleFactory;

public class SimpleCarFactory {

    public static CarInterface getCar(String carName){
        if(carName.equals("五菱宏光")){
            return new WuLingCar();
        }else if(carName.equals("路虎")){
            return new LuHuCar();
        }else{
            return null;
        }
    }

}
