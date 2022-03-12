package com.example.item.auditionParctice.single;

/**
 * 懒汉式静态内部类
 */
public class Holder {

    public Holder(){

    }

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    public static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }

    public static void main(String[] args) {
        System.out.println(Holder.getInstance());
        System.out.println(Holder.getInstance());
    }

}
