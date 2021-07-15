package com.example.item.utils;

import com.example.item.domain.Query;
import com.example.item.domain.annation.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * jdbc工具类
 *
 * @author tuzy create 2019年1月17日下午9:14:14
 */
@Slf4j
public class JdbcUtils {

    /**
     * MYSQL获取分页查询sql
     *
     * @param sql sql语句
     * @return 分页sql
     */
    public static String getLimitSql(String sql) {
        return getLimitSql(sql, null);
    }

    /**
     * MYSQL获取分页查询sql
     *
     * @param sql  sql语句
     * @param sort 排序sql
     * @return 分页sql
     */
    public static String getLimitSql(String sql, Sort sort) {

        Pageable page = ContextUtil.getPageRequest();
        return sql + getSortSql(sort) + " limit " + (page.getPageNumber()) * page.getPageSize() + "," + page
                .getPageSize();
    }

    public static StringBuilder getSortSql(Sort sort) {
        StringBuilder sb = new StringBuilder(512);
        if (sort != null && sort.isSorted()) {
            sb.append(" order by ");
            List<String> orders = new ArrayList<>();
            sort.forEach(order -> orders.add(order.getProperty() + " " + order.getDirection().name().toLowerCase()));
            if (!orders.isEmpty()) {
                sb.append(' ');
                sb.append(String.join(",", orders));
            }
        }
        return sb;
    }

    /**
     * 获取分页查询总数sql
     *
     * @param sql 查询sql
     * @return count sql
     */
    public static String getCountSql(String sql) {
        String countSql = "select count(*) temp_count" + sql.substring(sql.toLowerCase().indexOf(" from"));
        if (sql.toLowerCase().indexOf("group by") > 0) {
            countSql = "select count(*) temp_count from (" + sql + ") t";
        }
        return countSql;
    }

    /**
     * 根据类字段获取查询条件，使用 ? 占位
     *
     * @return Where
     */
    public static Query.Where queryWhere(Object obj) {
        return queryWhere(obj, false);
    }

    public static String getLikeValue(Like likeAnnotation, Object value) {
        // 处理模糊查询
        StringBuilder pattern = new StringBuilder();
        if (likeAnnotation.usePrefix()) {
            pattern.append("%");
        }
        pattern.append(value);
        if (likeAnnotation.useSuffix()) {
            pattern.append("%");
        }
        return pattern.toString();
    }

    /**
     * 根据类字段获取查询条件
     *
     * @param useField 使用 ? 还是使用 字段名 称作为通配符
     * @return SQL条件
     */
    private static Query.Where queryWhere(Object obj, boolean useField) {
        StringBuilder sb = new StringBuilder(1024);
        List<Object> params = new ArrayList<>();
        Object value = null;
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                value = f.get(obj);
            } catch (Exception e1) {
                log.debug(e1.toString());
            }
            if (CheckUtil.isBlank(value) || f.isAnnotationPresent(Ignore.class) || (value instanceof List
                    && ((List<?>) value).size() == 0)) {
                continue;
            }

            String fieldName = f.getName();
            if (f.isAnnotationPresent(DBField.class)) {
                fieldName = f.getAnnotation(DBField.class).value();
            }
            sb.append(" and ");
            if (f.isAnnotationPresent(TableAlias.class)) {
                TableAlias ta = f.getAnnotation(TableAlias.class);
                sb.append(ta.value());
                sb.append(".");
                if (CheckUtil.isNotBlank(ta.name())) {
                    fieldName = ta.name();
                }
            }
            if (f.isAnnotationPresent(Like.class)) {
                // 处理模糊查询
                Like likeAnnotation = f.getAnnotation(Like.class);
                value = getLikeValue(likeAnnotation, value);
                sb.append(getDBField(fieldName));
                sb.append(" like ");
            } else if (f.isAnnotationPresent(GreaterThan.class)) {
                GreaterThan gtAnnotation = f.getAnnotation(GreaterThan.class);
                if (CheckUtil.isNotBlank(gtAnnotation.name())) {
                    sb.append(gtAnnotation.name());
                } else {
                    sb.append(getDBField(fieldName));
                }
                if (gtAnnotation.equal()) {
                    sb.append(" >= ");
                } else {
                    sb.append(" > ");
                }
            } else if (f.isAnnotationPresent(LessThan.class)) {
                LessThan ltAnnotation = f.getAnnotation(LessThan.class);
                if (CheckUtil.isNotBlank(ltAnnotation.name())) {
                    sb.append(ltAnnotation.name());
                } else {
                    sb.append(getDBField(fieldName));
                }
                if (ltAnnotation.equal()) {
                    sb.append(" <= ");
                } else {
                    sb.append(" < ");
                }
            } else if (f.isAnnotationPresent(In.class)) {
                In in = f.getAnnotation(In.class);
                if (value instanceof List) {
                    sb.append(in.dbName()).append(" in (");
                    for (Object o : (List<?>) value) {
                        sb.append("?,");
                        if (o instanceof String) {
                            params.add(o.toString());
                        } else if (o instanceof Integer) {
                            params.add(o);
                        } else if (o instanceof Long) {
                            params.add(o);
                        } else if (o instanceof BigInteger) {
                            params.add(o);
                        } else {
                            throw new RuntimeException("不支持的list参数类型");
                        }
                    }
                    sb.deleteCharAt(sb.length() - 1).append(")");
                }
                continue;
            } else {
                sb.append(getDBField(fieldName));
                sb.append(" = ");
            }


            if (useField) {
                sb.append(" :");
                sb.append(f.getName());
            } else {
                sb.append(" ?");
            }
            params.add(value);


        }

        return new Query.Where(sb.toString(), params);
    }

    /**
     * 自定义sql条件转换为sql语句和参数
     *
     * @param sb      sql语句
     * @param whereLs 条件集合
     * @param params  参加集合
     */
    public static void dealWhere(StringBuilder sb, List<Query.Where> whereLs, List<Object> params) {
        for (Query.Where w : whereLs) {
            sb.append(" ");
            String sql = w.getSql();
            List<Object> p = w.getParams();
            if (w.getParams() != null) {
                for (Object o : p) {
                    if (o instanceof List) {
                        Collection<?> c = (Collection<?>) o;
                        sql = sql.replaceFirst("in *\\( *\\? *\\)",
                                "in (" + String.join(",", Collections.nCopies(c.size(), "?")) + ")");
                        params.addAll(c);
                    } else {
                        params.add(o);
                    }
                }
            }
            sb.append(sql);
        }
    }

    /**
     * 动态替换sql中in一个为多个情况
     *
     * @param sql   sql语句
     * @param count 需要问号个数
     * @return 替换后sql
     */
    public static String dealSqlWithIn(String sql, int count) {
        if (count < 1) {
            throw new RuntimeException("dealSqlWithIn count必须大于0");
        } else if (count == 1) {
            return sql.replaceFirst("in *\\( *\\? *\\)", " = ?");
        }
        return sql.replaceFirst("in *\\( *\\? *\\)", "in (" + String.join(",", Collections.nCopies(count, "?")) + ")");
    }

    /**
     * 驼峰式命名转数据库下划线分割
     *
     * @param name 数据库名称
     * @return 转换后值
     */
    public static String getDBField(String name) {
        StringBuilder sb = new StringBuilder(name.length() + 8);
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (i > 0 && Character.isUpperCase(ch)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(ch));
        }
        return sb.toString();
    }


}
