package com.example.item.auditionParctice.strategyAndFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>(StrategyFactory)</b>
 * 策略+工厂模式
 *
 * @author Rainy 2023-01-02 20:24:46
 * @version 1.0.0
 */
public class StrategyFactory {

    public static Map<String, StrategyInterface> strategyFactory = new HashMap<>(16);

    public static StrategyInterface getStrategy(String name) {
        return strategyFactory.get(name);
    }

    static void registerStrategy(String name, StrategyInterface strategy) {
        strategyFactory.put(name, strategy);
    }

}
