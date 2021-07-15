package com.example.item.domain.annation;

import java.lang.annotation.*;

/**
 * JAP字段小于[等于]时使用
 * 
 * 只适应于Number和Date
 * 
 * @author tuzy create 2018年12月12日上午8:40:29
 */
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface LessThan {
    /**
     * 是否查询相等
     * 
     * @return boolean
     */
    boolean equal() default true;

    /**
     * 数据库字段名，为空时取注解所在字段名
     */
    String name() default "";

}
