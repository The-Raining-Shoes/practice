package com.example.item.auditionParctice.strategy;

import java.math.BigDecimal;

/**
 * <b>(StrategyOne)</b>
 *
 * @author Rainy 2022-12-29 16:00:59
 * @version 1.0.0
 */
public class StrategyOne implements StrategyInterface<BigDecimal> {

    @Override
    public BigDecimal dealMoney(BigDecimal money, BigDecimal decrease) {
        return money.multiply(decrease);
    }

}
