package com.example.item.invocationConfig;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <b>(BaseInvocation)</b>
 *
 * @author Rainy 2023-02-17 16:07:58
 * @version 1.0.0
 */
public class BaseInvocation<T> implements InvocationHandler, FactoryBean<T>, BeanNameAware {

    private String className;
    private Class<?> classBean;
    private T proxyClass;

    @SuppressWarnings(value = "unchecked")
    public BaseInvocation(Class<T> classBean) {
        this.classBean = classBean;
        proxyClass = (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{this.classBean}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("动态代理成功-开始执行自定义方法");
        return null;
    }

    @Override
    public void setBeanName(String name) {
        className = name;
    }

    @Override
    public T getObject() {
        return proxyClass;
    }

    @Override
    public Class<?> getObjectType() {
        return classBean;
    }
}
