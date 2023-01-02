package com.example.item.auditionParctice.strategyAndFactory;

import org.springframework.beans.factory.InitializingBean;

/**
 * <b>(StrategyInterface)</b>
 * 策略接口
 *
 * @author Rainy 2023-01-02 20:21:16
 * @version 1.0.0
 */
public interface StrategyInterface extends InitializingBean {

    String getStrategyName();

    void AAA(String name);

}
