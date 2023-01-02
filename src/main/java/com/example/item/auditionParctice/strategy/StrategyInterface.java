package com.example.item.auditionParctice.strategy;

import java.math.BigDecimal;

/**
 * <b>(StrategyInterface)</b>
 *
 * @author Rainy 2022-12-29 15:58:52
 * @version 1.0.0
 */
public interface StrategyInterface<T> {

    /**
     * 计算金额方法
     *
     * @param money    原始金币
     * @param decrease 操作
     * @return 实际钱
     */
    BigDecimal dealMoney(BigDecimal money, T decrease);

}
