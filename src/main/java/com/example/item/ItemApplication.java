package com.example.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@EnableJpaRepositories()
@EnableCaching
//可以用自建JPA源
@EnableJpaRepositories(repositoryFactoryBeanClass = JpaRepositoryFactoryBean.class)
public class ItemApplication {

    public static void main(String[] args) {
        SpringApplication arr = new SpringApplication(ItemApplication.class);
        arr.setAdditionalProfiles("application");
        arr.run(args);
//		SpringApplication.run(ItemApplication.class, args);
    }
}
