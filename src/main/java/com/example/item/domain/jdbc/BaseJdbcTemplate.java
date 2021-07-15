package com.example.item.domain.jdbc;

import com.example.item.domain.Query;
import com.example.item.domain.dto.AbstractDTO;
import com.example.item.utils.ContextUtil;
import com.example.item.utils.JdbcUtils;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.*;

/**
 * jdbc操作
 */
public abstract class BaseJdbcTemplate extends JdbcTemplate {

    public BaseJdbcTemplate() {
        super();
    }

    public BaseJdbcTemplate(DataSource dataSource) {
        super(dataSource);
    }

    public BaseJdbcTemplate(DataSource dataSource, boolean lazyInit) {
        super(dataSource, lazyInit);
    }

    /**
     * 根据SQL获取COUNT SQL
     *
     * @param sql SQL
     * @return 查询总条数sql
     */
    protected abstract String getCountSql(String sql);

    /**
     * 根据SQL获取分页SQL
     *
     * @param sql  SQL
     * @param sort 排序参数 可能为NULL
     * @return String
     */
    protected abstract String getLimitSql(String sql, Sort sort);

    /**
     * 查询
     *
     * @param clazzTo 返回实体Class
     * @param sql     查询SQL
     * @param dto     查询实体 AbstractDTO子类
     * @param args    查询参数
     * @param <T>     返回值类型
     * @return Page
     */
    public <T> Page<T> queryForBeans(Class<T> clazzTo, String sql, AbstractDTO dto, Object... args) {
        return queryForBeans(clazzTo, sql, dto, new Query(), new ArrayList<>(Arrays.asList(args)));
    }

    /**
     * 查询
     *
     * @param clazzTo 返回实体Class
     * @param sql     查询SQL
     * @param query   查询Query
     * @param args    查询参数
     * @param <T>     返回值类型
     * @return Page
     */
    public <T> Page<T> queryForBeans(Class<T> clazzTo, String sql, Query query, Object... args) {
        return queryForBeans(clazzTo, sql, null, query, new ArrayList<>(Arrays.asList(args)));
    }

    /**
     * 返回单个实体对象，如果没有数据返回null，如果数据多于1条抛异常
     *
     * @param clazzTo  返回对象
     * @param querySql 查询sql
     * @param params   查询参数
     * @return T
     */
    public <T> T queryForBean(Class<T> clazzTo, String querySql, Object... params) {
        List<T> beans = queryForList(clazzTo, querySql, params);
        if (beans.size() == 0) {
            return null;
        } else if (beans.size() == 1) {
            return beans.get(0);
        } else {
            throw new IncorrectResultSizeDataAccessException(1, beans.size());
        }
    }

    /**
     * 返回一个查询列表, 列表中的对象类型为clazzTo参数指定的类型对象。 改方法适用于查询SQL中使用?作为参数占位符的SQL语句
     *
     * @param clazzTo  结果对象
     * @param querySql 查询sql
     * @param params   查询参数
     * @return List<T>
     */
    public <T> Page<T> queryForBeans(Class<T> clazzTo, String querySql, Object... params) {
        return queryForBeans(clazzTo, querySql, new ArrayList<>(Arrays.asList(params)));
    }

    /**
     * 查询
     *
     * @param clazzTo 返回实体Class
     * @param sql     查询SQL
     * @param dto     查询实体 AbstractDTO子类
     * @param sort    排序参数
     * @param args    查询参数
     * @param <T>     返回值类型
     * @return Page
     */
    public <T> Page<T> queryForBeans(Class<T> clazzTo, String sql, AbstractDTO dto, Sort sort, Object... args) {
        return queryForBeans(clazzTo, sql, dto, new Query(sort), new ArrayList<>(Arrays.asList(args)));
    }

    /**
     * 查询
     *
     * @param clazzTo 返回实体Class
     * @param sql     查询SQL
     * @param dto     查询实体 AbstractDTO子类
     * @param query   查询语句及参数
     * @param params  查询参数
     * @param <T>     返回值类型
     * @return Page
     */
    public <T> Page<T> queryForBeans(Class<T> clazzTo, String sql, AbstractDTO dto, Query query, List<Object> params) {
        if (Objects.nonNull(dto)) {
            query.add(0, JdbcUtils.queryWhere(dto));
        }
        return queryForBeans(clazzTo, query.appendToSql(sql, params), params, query.getSort());
    }

    /**
     * 查询
     *
     * @param clazzTo 返回实体Class
     * @param sql     查询SQL
     * @param params  查询参数
     * @param <T>     返回值类型
     * @return Page
     */
    public <T> Page<T> queryForBeans(Class<T> clazzTo, String sql, List<Object> params) {
        return queryForBeans(clazzTo, sql, params, null);
    }

    /**
     * 查询并排序
     *
     * @param clazzTo 返回实体Class
     * @param sql     查询SQL
     * @param params  查询参数
     * @param sort    排序参数
     * @param <T>     返回值类型
     * @return Page
     */
    public <T> Page<T> queryForBeans(Class<T> clazzTo, String sql, List<Object> params, Sort sort) {
        //return getPage(listRows(clazzTo, this.getLimitSql(sql, sort), params), getTotal(this.getCountSql(sql), params));
        return queryForBeans(clazzTo, this.getLimitSql(sql, sort), this.getCountSql(sql), params);
    }


    /**
     * @param clazzTo  返回实体Class
     * @param limitSql 分页sql
     * @param countSql 查询总条数SQL
     * @param params   查询参数
     * @param <T>      返回值类型
     * @return Page
     */
    public <T> Page<T> queryForBeans(Class<T> clazzTo, String limitSql, String countSql, List<Object> params) {
        Long total = getTotal(countSql, params);
        if (total == 0) {
            return getPage(new ArrayList<>(), 0L);
        }
        return getPage(listRows(clazzTo, limitSql, params), total);
    }

    /**
     * 查询分页数据
     *
     * @param clazzTo 返回实体Class
     * @param sql     查询SQL
     * @param params  查询参数
     * @param <T>     返回值类型
     * @return List
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> listRows(Class<T> clazzTo, String sql, List<Object> params) {
        List<T> rows;
        if (Map.class.isAssignableFrom(clazzTo)) {
            rows = (List<T>) queryForList(sql, params);
        } else {
            rows = query(sql, getBeanPropertyRowMapper(clazzTo), params.toArray());
        }
        return rows;
    }

    protected <T> RowMapper<T> getBeanPropertyRowMapper(Class<T> clazzTo) {
        return BeanPropertyRowMapper.newInstance(clazzTo);
    }

    /**
     * 获取总条数
     *
     * @param countSql 查询总条数SQL sql语句
     * @param params   查询参数   参数
     * @return Long
     */
    public Long getTotal(String countSql, List<Object> params) {
        return this.queryForObject(countSql, Long.class, params.toArray());
    }

    /**
     * 获取分页对象
     *
     * @param rows  当前页数据
     * @param total 总条数
     * @param <T>   返回值类型   返回对象类型
     * @return Page
     */
    public <T> Page<T> getPage(List<T> rows, Long total) {
        return PageableExecutionUtils.getPage(rows, ContextUtil.getPageRequest(), () -> total);
    }


    /**
     * 不分页查询
     *
     * @param clazzTo 返回实体Class
     * @param sql     查询SQL
     * @param dto     查询实体 AbstractDTO子类
     * @param args    查询参数
     * @param <T>     返回值类型
     * @return List
     */
    public <T> List<T> queryForList(Class<T> clazzTo, String sql, AbstractDTO dto, Object... args) {
        return queryForList(clazzTo, sql, dto, new Query(), new ArrayList<>(Arrays.asList(args)));
    }

    /**
     * 不分页查询
     *
     * @param clazzTo 返回实体Class
     * @param sql     查询SQL
     * @param query   查询实体 Query
     * @param args    查询参数
     * @param <T>     返回值类型
     * @return List
     */
    public <T> List<T> queryForList(Class<T> clazzTo, String sql, Query query, Object... args) {
        return queryForList(clazzTo, sql, null, query, new ArrayList<>(Arrays.asList(args)));
    }

    /**
     * 不分页查询
     *
     * @param clazzTo 返回实体Class
     * @param sql     查询SQL
     * @param dto     查询实体 AbstractDTO子类
     * @param sort    排序参数
     * @param args    查询参数
     * @param <T>     返回值类型
     * @return List
     */
    public <T> List<T> queryForList(Class<T> clazzTo, String sql, AbstractDTO dto, Sort sort, Object... args) {
        return queryForList(clazzTo, sql, dto, new Query(JdbcUtils.queryWhere(dto), sort),
            new ArrayList<>(Arrays.asList(args)));
    }

    /**
     * 不分页查询
     *
     * @param clazzTo 返回实体Class
     * @param sql     查询SQL
     * @param dto     查询实体 AbstractDTO子类
     * @param query   查询语句及参数
     * @param params  查询参数
     * @param <T>     返回值类型
     * @return List
     */
    public <T> List<T> queryForList(Class<T> clazzTo, String sql, AbstractDTO dto, Query query, List<Object> params) {
        if (Objects.nonNull(dto)) {
            query.add(0, JdbcUtils.queryWhere(dto));
        }
        return queryForList(clazzTo, query.appendToSql(sql, params), params, query.getSort());
    }

    /**
     * 不分页查询
     *
     * @param clazzTo 返回实体Class
     * @param sql     查询SQL
     * @param params  查询参数
     * @param <T>     返回值类型
     * @return List
     */
    public <T> List<T> queryForList(Class<T> clazzTo, String sql, List<Object> params) {
        return queryForList(clazzTo, sql, params, null);
    }

    /**
     * 不分页查询
     *
     * @param clazzTo 返回实体Class
     * @param sql     查询SQL
     * @param params  查询参数
     * @param <T>     返回值类型
     * @return List
     */
    public <T> List<T> queryForList(Class<T> clazzTo, String sql, Object... params) {
        return listRows(clazzTo, sql, new ArrayList<>(Arrays.asList(params)));
    }

    /**
     * 不分页查询
     *
     * @param clazzTo 返回实体Class
     * @param sql     查询SQL
     * @param params  查询参数
     * @param sort    排序参数
     * @param <T>     返回值类型
     * @return List
     */
    public <T> List<T> queryForList(Class<T> clazzTo, String sql, List<Object> params, Sort sort) {
        return listRows(clazzTo, sql + JdbcUtils.getSortSql(sort), params);
    }

    // 不要使用这个方法，请使用jpa保存
    ///**
    // * 插入数据后返回主键
    // *
    // * @param sql 查询SQL          insert语句
    // * @param keyIdColName 主键名
    // * @param params 查询参数       参数
    // * @return 主键值
    // */
    //public Number insertAndGetKey(String sql, String keyIdColName, Object... params) {
    //    GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
    //    this.update(connection -> {
    //        PreparedStatement psst = connection.prepareStatement(sql, new String[] {keyIdColName});
    //        int i = 1;
    //        for (Object object : params) {
    //            if (object instanceof Integer) {
    //                psst.setInt(i, (Integer) object);
    //            } else if (object instanceof Date) {
    //                java.sql.Date date = new java.sql.Date(((Date) object).getTime());
    //                psst.setDate(i, date);
    //            } else if (object instanceof Double) {
    //                psst.setDouble(i, (Double) object);
    //            } else if (object instanceof Float) {
    //                psst.setFloat(i, (Float) object);
    //            } else if (object instanceof Long) {
    //                psst.setLong(i, (Long) object);
    //            } else if (object instanceof BigDecimal) {
    //                psst.setBigDecimal(i, (BigDecimal) object);
    //            } else {
    //                if (object == null) {
    //                    psst.setString(i, null);
    //                } else {
    //                    psst.setString(i, object.toString());
    //                }
    //            }
    //            i++;
    //        }
    //        return psst;
    //    }, keyHolder);
    //    return keyHolder.getKey();
    //}

}
