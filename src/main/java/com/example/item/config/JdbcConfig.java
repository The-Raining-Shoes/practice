package com.example.item.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Configuration;

/**
 * @Message 数据库配置
 * @Author: HXM
 * @Date: 2020/1/7 9:59
 */

@Configuration
public class JdbcConfig {
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.other")
//    public DataSource getMyDataSource() {
////       1.使用连接池 例:druid数据库连接池使用
////       DruidDataSource dataSource = new DruidDataSource();
////       dataSource.setUrl("")
////       dataSource.setXXXXXX
////       return dataSource
////       2.使用spring框架数据源装配
////       return DataSourceBuilder.create().build()
////       3.创建jdbc对象 传入自定义数据源(如下getOracle176ResHJDs())
////       JdbcTemplate jdbcTemplate = new JdbcTemplate(getOracle176ResHJDs(5));
//        return DataSourceBuilder.create().build();
//    }

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
