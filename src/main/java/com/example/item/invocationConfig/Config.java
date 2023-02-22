package com.example.item.invocationConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <b>(Config)</b>
 *
 * @author Rainy 2023-02-21 17:49:02
 * @version 1.0.0
 */
@Configuration
public class Config {

    @Bean("TestInterface")
    public BaseInvocationHandler testInterface() {
        return getService("com.example.item.invocationConfig.TestInterface");
    }


    private BaseInvocationHandler getService(String className) {
        return new BaseInvocationHandler(className);
    }

}
