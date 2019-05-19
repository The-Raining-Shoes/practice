package com.example.item.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
    @Bean(name = "MyDataSource")
    @Qualifier("MyDataSource")
    @ConfigurationProperties(prefix="spring.datasource.other")
    public DataSource getMyDataSource(){
        return DataSourceBuilder.create().build();
    }
    
}