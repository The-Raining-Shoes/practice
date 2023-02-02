package com.example.item.auditionParctice.strategy;

import lombok.Data;

import java.math.BigDecimal;

/**
 * <b>(StrategyTwo)</b>
 *
 * @author Rainy 2022-12-29 16:02:00
 * @version 1.0.0
 */
public class StrategyTwo implements StrategyInterface<StrategyTwo.StrategyTwoDetail> {

    @Override
    public BigDecimal dealMoney(BigDecimal money, StrategyTwoDetail decrease) {
        if (money.compareTo(decrease.getMoney()) > 0) {
            return money.subtract(decrease.getDecrease());
        }
        return money;
    }

    @Data
    public static class StrategyTwoDetail {
        private BigDecimal money;
        private BigDecimal decrease;
    }

}
