package com.example.item.InvocationHandler.entity;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class ApiBean<T> implements FactoryBean<T> {

    private final Class<T> beanClass;
    private final T bean;

    public ApiBean(Class<T> beanClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        this.beanClass = beanClass;
        this.bean = beanClass.getConstructor().newInstance();
    }

    /**
     * 自定义factoryBean类，动态代理时始终作为代理类处理
     *
     * @param beanClass         被代理的类
     * @param invocationHandler 代理处理类
     */
    public ApiBean(Class<T> beanClass, InvocationHandler invocationHandler) {
        this.beanClass = beanClass;
        this.bean = this.proxyBean(invocationHandler);
    }

    /**
     * bean注册的时候进行动态代理
     *
     * @param invocationHandler 代理类
     * @return T
     */
    @SuppressWarnings(value = "unchecked")
    public T proxyBean(InvocationHandler invocationHandler) {
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
