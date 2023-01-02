package com.example.item.method.functionTest;

import java.util.function.Function;

/**
 * <b>(FuncTionTest)</b>
 *
 * @author Rainy 2022-12-06 16:46:08
 * @version 1.0.0
 */
public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        functionTest.code();
    }

    public String test(Function<String, String> function) {
        return function.apply("1");
    }

    public void code() {
        System.out.println(test(e -> "2"));
    }

}
