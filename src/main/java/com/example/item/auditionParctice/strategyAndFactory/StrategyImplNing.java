package com.example.item.auditionParctice.strategyAndFactory;

import org.springframework.stereotype.Component;

/**
 * <b>(StrategyImplNing)</b>
 * 策略实现类
 *
 * @author Rainy 2023-01-02 20:22:53
 * @version 1.0.0
 */
@Component
public class StrategyImplNing implements StrategyInterface{

    @Override
    public String getStrategyName() {
        return "StrategyImplNing";
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
