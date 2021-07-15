package com.example.item.domain.annation;

import java.lang.annotation.*;

/**
 * JAP模糊查询
 * 只适应于String
 *
 * @author tuzy create 2018年12月12日上午8:40:29
 */
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Like {
    /**
     * 字段前加%
     */
    boolean usePrefix() default true;

    /**
     * 字段后加%
     */
    boolean useSuffix() default true;

}
