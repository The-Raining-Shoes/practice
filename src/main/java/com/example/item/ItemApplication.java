package com.example.item;

import com.example.item.InvocationHandler.entity.ApiBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Rainy
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients(basePackages = {"com.example.item"})
@EnableCaching
public class ItemApplication {

    public static void main(String[] args) {
        SpringApplication arr = new SpringApplication(ItemApplication.class);
        arr.setAdditionalProfiles("application");
        arr.run(args);
        try {
            new ApiBean<>(SomeStuff.class);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            System.out.println("装载SomeStuff失败");
        }
    }
}
