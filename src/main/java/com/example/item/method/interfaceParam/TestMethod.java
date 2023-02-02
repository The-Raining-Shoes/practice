package com.example.item.method.interfaceParam;

/**
 * <b>(TestMethod)</b>
 *
 * @author Rainy 2022-12-06 15:23:20
 * @version 1.0.0
 */
public class TestMethod {

    public static void main(String[] args) {
        MethodImpl method = new MethodImpl();
        method.execute(StaticClass::c);
    }

}
