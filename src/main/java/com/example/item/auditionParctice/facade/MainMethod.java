package com.example.item.auditionParctice.facade;

/**
 * <b>(MainMethod)</b>
 *
 * @author Rainy 2023-01-02 21:22:49
 * @version 1.0.0
 */
public interface MainMethod {

    default void executeMethod(MethodOne methodOne, MethodTwo methodTwo) {
        methodTwo.BBB();
        methodOne.AAA();
    }

    void execute();

}
