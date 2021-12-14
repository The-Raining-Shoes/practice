package com.example.item.InvocationHandler.actuatorConfig;

import com.example.item.InvocationHandler.TestHttpMethodService;
import com.example.item.InvocationHandler.apiActuator.TESTApiActuator;
import com.example.item.InvocationHandler.entity.ApiBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TESTActuatorConfig {

    @Bean
    TESTApiActuator getApiActuator(RestTemplateBuilder builder) {
        return new TESTApiActuator(builder.build(), "test", "testCode");
    }

    @Bean
    ApiBean<TestHttpMethodService> getBean(TESTApiActuator testApiActuator) {
        return new ApiBean<>(TestHttpMethodService.class, testApiActuator);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }



}
