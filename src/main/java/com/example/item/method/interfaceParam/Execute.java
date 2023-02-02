package com.example.item.method.interfaceParam;

/**
 * <b>(Execute)</b>
 * 接口作为参数调用
 *
 * @author Rainy 2022-12-06 15:21:06
 * @version 1.0.0
 */
public interface Execute<T> {

    T doTest(StaticClass test);

}
