package com.example.item.config;

import com.example.item.domain.jdbc.BeanJdbcTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class MyDoubleMysqlConfig {

    @Bean(name = "myDataOne")
    @ConfigurationProperties(prefix = "spring.datasource.other")
    public DataSource myDatasourceOne() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcTemplate")
    @ConditionalOnMissingBean(value = JdbcTemplate.class)
    public JdbcTemplate jdbcTemplate(@Qualifier(value = "myDataOne") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "myDataTwo")
    @ConfigurationProperties(prefix = "spring.datasource.my")
    public DataSource myDatasourceTwo() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "beanJdbcTemplate")
    @ConditionalOnMissingBean(value = BeanJdbcTemplate.class)
    public BeanJdbcTemplate beanJdbcTemplate(@Qualifier(value = "myDataTwo") DataSource dataSource) {
        return new BeanJdbcTemplate(dataSource);
    }

}
