package com.example.item.functionDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * <b>(ExecuteMethod)</b>
 *
 * @author Rainy 2023-02-01 12:09:14
 * @version 1.0.0
 */
public class ExecuteMethod {

    static List<TypeClassOne> typeOne = new ArrayList<>();
    static List<TypeClassTwo> typeTwo = new ArrayList<>();

    static {
        typeOne.add(TypeClassOne.builder().type(1).name("TypeClassOne-1").build());
        typeOne.add(TypeClassOne.builder().type(2).name("TypeClassOne-2").build());
        typeTwo.add(TypeClassTwo.builder().type(1).name("TypeClassTwo-1").build());
        typeTwo.add(TypeClassTwo.builder().type(2).name("TypeClassTwo-2").build());
    }

    public static void main(String[] args) {
        typeOne.forEach(e -> {
            if (e.getType() == 1) {
                testMethod(TypeClassTwo::getName);
            } else {
                testMethod(TypeClassTwo::getNameTwo);
            }
        });
    }

    public static void testMethod(Function<TypeClassTwo, String> function) {
        typeTwo.forEach(e -> System.out.println(function.apply(e)));
    }

}
