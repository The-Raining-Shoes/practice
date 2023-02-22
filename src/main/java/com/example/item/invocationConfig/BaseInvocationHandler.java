package com.example.item.invocationConfig;

import lombok.Getter;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <b>(BaseInvocationHandler)</b>
 *
 * @author Rainy 2023-02-21 17:44:17
 * @version 1.0.0
 */
public class BaseInvocationHandler implements InvocationHandler, FactoryBean, InitializingBean {

    @Getter
    private final String serviceClazz;
    private Object object;
    private Class<?> aClass;

    public BaseInvocationHandler(String className) {
        this.serviceClazz = className;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理方法进来了,下面执行自定义逻辑");
        return null;
    }

    @Override
    public Object getObject() throws Exception {
        return object;
    }

    @Override
    public Class<?> getObjectType() {
        return aClass;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

}
