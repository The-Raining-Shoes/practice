package com.example.item.auditionParctice.facade;

/**
 * <b>(ExecuteMethod)</b>
 *
 * @author Rainy 2023-01-02 21:28:44
 * @version 1.0.0
 */
public class ExecuteMethod {

    public static void main(String[] args) {
        MainMethod mainMethod = new MainMethodImpl(new MethodOneImpl(), new MethodTwoImpl());
        mainMethod.execute();
    }

}
