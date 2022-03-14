package com.example.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication()
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableCaching
//@MapperScan(basePackages = {"com.example.item.domain.mapper"}) // 扫描我们自定义文件目录下的文件
//可以用自建的JPA源码
//@EnableJpaRepositories(repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class ItemApplication {

    public static void main(String[] args) {
        SpringApplication arr = new SpringApplication(ItemApplication.class);
        arr.setAdditionalProfiles("application");
        arr.run(args);
//		SpringApplication.run(ItemApplication.class, args);
    }
}
