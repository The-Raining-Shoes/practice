package com.example.item.InvocationHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiCodeConfig {

    @Bean
    ApiActuator apiActuator() {
        TestCodeInterfaceImpl testCodeInterface = new TestCodeInterfaceImpl();
        return new ApiActuator("code", "password2", testCodeInterface);
    }

    @Bean
    ApiBean<TestCodeInterface> testCodeInterfaceApiBean(ApiActuator apiActuator) {
        return new ApiBean<>(TestCodeInterface.class, apiActuator);
    }

}
