package com.example.item.auditionParctice.single;


public class HungMan {

    public static HungMan hungMan = new HungMan();

    public HungMan(){

    }

    public static HungMan getInstance() {
        return hungMan;
    }

}
