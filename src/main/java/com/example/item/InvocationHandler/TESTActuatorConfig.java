package com.example.item.InvocationHandler;

import com.example.item.InvocationHandler.entity.ApiBean;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class TESTActuatorConfig {

    @Setter(onMethod_ = @Autowired)
    private StringRedisTemplate stringRedisTemplate;

    @Bean
    TESTApiActuator getApiActuator() {
        return new TESTApiActuator(new RestTemplateBuilder().rootUri("www")
                .defaultHeader("Content-Type", "application/json").build(), "test", "testCode");
    }

    @Bean
    ApiBean<TestHttpMethodService> getBean(TESTApiActuator testApiActuator) {
        testApiActuator.setStringRedisTemplate(stringRedisTemplate);
        return new ApiBean<>(TestHttpMethodService.class, testApiActuator);
    }


}
