package com.example.item.thread.function;

import java.util.function.Supplier;

/**
 * 供给型接口 (无参数，直接返回数据)
 */
public class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "测试数据";
        System.out.println(supplier.get());
    }


}

