package com.example.item.config;

import com.example.item.domain.jdbc.BeanJdbcTemplate;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.JdbcProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
* @Message 数据库配置
* @Author: HXM
* @Date: 2020/1/7 9:59
*/

@Configuration
public class JdbcConfig {

   @Bean
   @Primary
   public BeanJdbcTemplate jdbcTemplate(DataSource dataSource, JdbcProperties properties) {
       BeanJdbcTemplate jdbcTemplate = new BeanJdbcTemplate(dataSource);
       JdbcProperties.Template template = properties.getTemplate();
       jdbcTemplate.setFetchSize(template.getFetchSize());
       jdbcTemplate.setMaxRows(template.getMaxRows());
       if (template.getQueryTimeout() != null) {
           jdbcTemplate.setQueryTimeout((int) template.getQueryTimeout().getSeconds());
       }
       return jdbcTemplate;
   }

   @Bean
   @ConfigurationProperties(prefix = "spring.datasource.other")
   public DataSource getMyDataSource() {
//       1.使用连接池 例:druid数据库连接池使用
//       DruidDataSource dataSource = new DruidDataSource();
//       dataSource.setUrl("")
//       dataSource.setXXXXXX
//       return dataSource
//       2.使用spring框架数据源装配
//       return DataSourceBuilder.create().build()
//       3.创建jdbc对象 传入自定义数据源(如下getOracle176ResHJDs())
//       JdbcTemplate jdbcTemplate = new JdbcTemplate(getOracle176ResHJDs(5));
//       4.使用spring自动数据源配置(properties中配置)
       return DataSourceBuilder.create().build();
   }

   public static HikariDataSource getMysql3306ResHJDs(int poolSize) {
       HikariConfig config = new HikariConfig();
       config.setJdbcUrl("jdbc:mysql://39.106.114.95:3306/test");
       config.setUsername("root");
       config.setPassword("199678");
       config.setDriverClassName("com.mysql.cj.jdbc.Driver");
       config.setMaximumPoolSize(poolSize);
       return new HikariDataSource(config);
   }
}
