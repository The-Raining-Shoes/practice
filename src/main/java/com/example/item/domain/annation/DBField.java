package com.example.item.domain.annation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 数据库名称 用于实体字段和数据库名称不一致
 * 
 * 
 * @author tuzy create 2019年4月13日上午10:17:10
 */
@Target({FIELD})
@Retention(RUNTIME)
public @interface DBField {
    /**
     * 名称
     */
    String value();
}
