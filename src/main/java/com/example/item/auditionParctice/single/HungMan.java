package com.example.item.auditionParctice.single;

/**
 * 饿汉式单例：可能会浪费一些空间，是内存安全的
 */
public class HungMan {

    public final static HungMan hungMan = new HungMan();

    public HungMan(){

    }

    public static HungMan getInstance() {
        return hungMan;
    }

}
