package com.example.item.auditionParctice.facade;

/**
 * <b>(MainMethodImpl)</b>
 *
 * @author Rainy 2023-01-02 21:26:25
 * @version 1.0.0
 */
public class MainMethodImpl implements MainMethod {

    MethodOne methodOne;
    MethodTwo methodTwo;

    public MainMethodImpl(MethodOne methodOne, MethodTwo methodTwo) {
        this.methodOne = methodOne;
        this.methodTwo = methodTwo;
    }

    @Override
    public void execute() {
        executeMethod(methodOne, methodTwo);
    }

}
