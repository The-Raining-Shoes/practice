package com.example.item.auditionParctice.builder.demo1;

public class ExecuteMethod {
    public static void main(String[] args) {
        Directer directer = new Directer();
        directer.behavior(new Worker());
    }
}
