package com.example.item.InvocationHandler;

import org.springframework.beans.factory.FactoryBean;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ApiBean<T> implements FactoryBean<T> {
    private final Class<T> beanClass;
    private final T bean;

    public ApiBean(Class<T> beanClass, InvocationHandler invocationHandler) {
        this.beanClass = beanClass;
        this.bean = this.getProxy(invocationHandler);
    }

    @SuppressWarnings("unchecked")
    private T getProxy(InvocationHandler invocationHandler) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{this.beanClass}, invocationHandler);
    }

    @Override
    public T getObject() {
        return this.bean;
    }

    @Override
    public Class<?> getObjectType() {
        return this.beanClass;
    }

}
