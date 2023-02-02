package com.example.item.auditionParctice.strategy;

import org.apache.poi.ss.formula.functions.T;

import java.math.BigDecimal;

/**
 * <b>(ExecuteClass)</b>
 * 策略模式
 *
 * @author Rainy 2022-12-29 16:04:43
 * @version 1.0.0
 */
public class ExecuteClass<T> {

    private final StrategyInterface<T> strategyInterface;

    public ExecuteClass(StrategyInterface<T> strategyInterface) {
        this.strategyInterface = strategyInterface;
    }

    public BigDecimal executeMethod(BigDecimal price, T couponInfo) {
        return this.strategyInterface.dealMoney(price, couponInfo);
    }

}
