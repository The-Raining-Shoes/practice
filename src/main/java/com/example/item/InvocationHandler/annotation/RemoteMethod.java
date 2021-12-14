package com.example.item.InvocationHandler.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 接口配置字段
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RemoteMethod {

    String name();

    String url();

    String desc();

    String urlMethod();

    HttpMethod httpMethod() default HttpMethod.GET;

    enum HttpMethod {
        GET,
        POST
    }

}
