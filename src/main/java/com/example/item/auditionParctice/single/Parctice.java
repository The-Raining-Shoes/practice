package com.example.item.auditionParctice.single;

public class Parctice {

    public static void main(String[] args) throws Exception {
        HungMan hungMan = new HungMan();
        HungMan instance = hungMan.getInstance();
        System.out.println(instance);
        System.out.println(hungMan);
//        LazyMan lazyMan1 = LazyMan.getInstance();
        LazyMan lazyMan1 = LazyMan.class.getDeclaredConstructor().newInstance();
//        LazyMan lazyMan2 = LazyMan.class.getDeclaredConstructor().newInstance();
//        System.out.println(lazyMan1);
//        System.out.println(lazyMan2);
    }

}
