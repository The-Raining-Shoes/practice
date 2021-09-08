//package com.example.item.InvocationHandler;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ApiNameConfig {
//
//    @Bean
//    ApiActuator apiActuator() {
//        return new ApiActuator("name", "password1");
//    }
//
//    @Bean
//    ApiBean<TestCodeInterface> testCodeInterfaceApiBean(ApiActuator apiActuator) {
//        return new ApiBean<>(TestCodeInterface.class, apiActuator);
//    }
//
//}
