package com.example.item.auditionParctice.strategy;

import java.math.BigDecimal;

/**
 * <b>(MainClass)</b>
 *
 * @author Rainy 2022-12-29 16:10:36
 * @version 1.0.0
 */
public class MainClass {

    public static void main(String[] args) {
        ExecuteClass<BigDecimal> strategyInterface = new ExecuteClass<>(new StrategyOne());
        System.out.println(strategyInterface.executeMethod(new BigDecimal("10"), new BigDecimal("0.8")));
    }

}
