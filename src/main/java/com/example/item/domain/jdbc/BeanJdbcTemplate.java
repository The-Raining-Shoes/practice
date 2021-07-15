package com.example.item.domain.jdbc;

import com.example.item.utils.JdbcUtils;
import org.springframework.data.domain.Sort;

import javax.sql.DataSource;

public class BeanJdbcTemplate extends BaseJdbcTemplate {

    public BeanJdbcTemplate(DataSource dataSource) {
        super(dataSource);
    }

    public BeanJdbcTemplate(DataSource dataSource, boolean lazyInit) {
        super(dataSource, lazyInit);
    }

    @Override
    protected String getCountSql(String sql) {
        return JdbcUtils.getCountSql(sql);
    }

    @Override
    protected String getLimitSql(String sql, Sort sort) {
        return JdbcUtils.getLimitSql(sql, sort);
    }
}
