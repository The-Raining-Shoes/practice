package com.example.item.auditionParctice.single;

import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicInteger;

public class MainMethod {

    public static void main(String[] args) throws Exception {
        AtomicInteger atomicInteger = new AtomicInteger();
        EnumSingle enumSingle1 = EnumSingle.getInstance();
        System.out.println(enumSingle1);
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class, String.class);
        declaredConstructor.setAccessible(true);
        EnumSingle enumSingle2 = declaredConstructor.newInstance("test", "test1");
        System.out.println(enumSingle2);
    }

}
