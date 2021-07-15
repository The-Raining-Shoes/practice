package com.example.item.domain.annation;

import java.lang.annotation.*;

/**
 * 查询忽略字段
 *
 * @author tuzy
 */
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Ignore {

}
