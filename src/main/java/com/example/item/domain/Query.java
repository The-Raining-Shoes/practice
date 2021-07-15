package com.example.item.domain;

import com.example.item.utils.JdbcUtils;
import lombok.*;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询参数
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Query {

    private List<Where> wheres;
    private Sort sort;

    public Query(Where queryWhere) {
        this(queryWhere, null);
    }

    public Query(Where queryWhere, Sort sort) {
        this.sort = sort;
        this.add(queryWhere);
    }

    public Query(Sort sort) {
        this.sort = sort;
    }


    public Query add(Query.Where where) {
        if (wheres == null) {
            this.wheres = new ArrayList<>();
        }
        wheres.add(where);
        return this;
    }

    public Query add(int index, Query.Where where) {
        if (wheres == null) {
            this.wheres = new ArrayList<>();
        }
        wheres.add(index, where);
        return this;
    }

    public String appendToSql(String sql, List<Object> params) {
        if (wheres != null && !wheres.isEmpty()) {
            StringBuilder sb = new StringBuilder(sql.length() + this.wheres.size() * 36);
            sb.append(sql);
            JdbcUtils.dealWhere(sb, this.wheres, params);
            return sb.toString();
        }
        return sql;
    }


    @Getter
    @ToString
    public static class Where {
        private String sql;
        private final List<Object> params;

        public Where(String sql) {
            this.sql = sql;
            this.params = new ArrayList<>();
        }

        public Where(String sql, List<Object> params) {
            this.sql = sql;
            this.params = params;
        }

        public Where param(Object obj) {
            this.params.add(obj);
            return this;
        }

        public Where paramIn(List<?> inLs) {
            this.sql = JdbcUtils.dealSqlWithIn(this.sql, inLs.size());
            this.params.addAll(inLs);
            return this;
        }

        public static Where of(String sql) {
            return new Where(sql);
        }

        public static Where of(String sql, Object obj) {
            return new Where(sql).param(obj);
        }

    }
}
