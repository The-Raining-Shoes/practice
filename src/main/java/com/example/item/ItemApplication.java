package com.example.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

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
//		SpringApplication.run(ItemApplication.class, args);
    }
}
