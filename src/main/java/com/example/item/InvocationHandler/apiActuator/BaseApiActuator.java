package com.example.item.InvocationHandler.apiActuator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BaseApiActuator implements InvocationHandler {

    private final ThreadLocal<Method> runMethod = new ThreadLocal<>();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        return this.execute(proxy, method, args);
    }

    public Object execute(Object proxy, Method method, Object[] args) {
        runMethod.set(method);
        return null;
    }

    /**
     * @param proxy
     * @param method
     * @param args
     * @return
     */
    public Object convertRequest(Object proxy, Method method, Object[] args) {
        return null;
    }


}
