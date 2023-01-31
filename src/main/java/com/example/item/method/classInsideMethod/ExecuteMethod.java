package com.example.item.method.classInsideMethod;

/**
 * <b>(ExecuteMethod)</b>
 * 互相依赖内部类
 *
 * @author Rainy 2023-01-01 11:14:18
 * @version 1.0.0
 */
public class ExecuteMethod {

    public static void main(String[] args) {
        InsideClassTwo insideClassTwo = new InsideClassTwo();
        InsideClassOne insideClassOne = insideClassTwo.rule();
        InsideClassTwo end = insideClassOne.end();
        System.out.println(insideClassOne.insideClassTwo);
        System.out.println(end.getRules());
    }

}
