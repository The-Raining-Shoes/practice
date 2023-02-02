package com.example.item.auditionParctice.strategyAndFactory;

import org.springframework.stereotype.Component;

/**
 * <b>(StrategyImplMao)</b>
 * 策略实现类
 *
 * @author Rainy 2023-01-02 20:22:31
 * @version 1.0.0
 */
@Component
public class StrategyImplMao implements StrategyInterface {

    @Override
    public String getStrategyName() {
        return "StrategyImplMao";
    }

    @Override
    public void AAA(String name) {
        System.out.println(getStrategyName().concat("处理了：") + name);
    }

    @Override
    public void afterPropertiesSet() {
        StrategyFactory.registerStrategy(getStrategyName(), this);
    }

}
