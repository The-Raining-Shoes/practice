package com.example.item.invocationConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <b>(Config)</b>
 *
 * @author Rainy 2023-02-17 16:09:01
 * @version 1.0.0
 */
@Configuration
public class Config {

    @Bean("TestInterface")
    BaseInvocation<TestInterface> baseInvocation() {
        return new BaseInvocation<>(TestInterface.class);
    }

}
