package com.example.item.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * <b>(SystemConfig)</b>
 *
 * @author Rainy 2023-01-01 11:43:22
 * @version 1.0.0
 */
@Configuration
public class SystemConfig {

    @Value("#{'${dynamic.config.system}'.split('\\|')}")
    private String[] systemCode;

    @Bean
    String testCode() {
        System.out.println(Arrays.toString(systemCode));
        return systemCode[1];
    }

}
