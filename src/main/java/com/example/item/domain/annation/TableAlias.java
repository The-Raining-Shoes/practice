package com.example.item.domain.annation;

import java.lang.annotation.*;

/**
 * 多表查询是别名
 * 
 * @author tuzy create 2019年1月4日15:02:24
 */
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface TableAlias {
    /**
     * 表别名
     * 
     * @return String
     */
    String value();

    /**
     * 表内字段名，默认为字段名称
     * 
     * @return String
     */
    String name() default "";

}
