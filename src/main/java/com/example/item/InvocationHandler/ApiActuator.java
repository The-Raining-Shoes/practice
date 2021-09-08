package com.example.item.InvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ApiActuator implements InvocationHandler {

    private final String code;
    private final String password;
    private final Object object;

    public ApiActuator(String code, String password, Object object) {
        this.code = code;
        this.password = password;
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        Object invoke = method.invoke(object, args);
        System.out.println(code);
        System.out.println(password);
        return invoke;
    }

//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        Object result = method.invoke(proxy, args);
//        System.out.println("账号:" + code + "密码:" + password +
//                "方法名:" + method.getName() + "执行类:" + proxy.getClass().toString() + "请求参数:" + Arrays.toString(args));
//        return result;
//    }

}
