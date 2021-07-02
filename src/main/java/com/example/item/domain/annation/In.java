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
public @interface In {

    /**
     * 数据库字段名，为空时取注解所在字段名
     */
    String dbName() default "";
}
