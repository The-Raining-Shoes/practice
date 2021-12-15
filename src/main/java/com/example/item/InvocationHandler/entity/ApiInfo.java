package com.example.item.InvocationHandler.entity;

import com.example.item.InvocationHandler.annotation.RemoteMethod;
import lombok.Data;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Data
public class ApiInfo {

    public String url;

    public String urlMethod;

    public RemoteMethod.HttpMethod httpMethod;

    public Method method;

    public String methodName;

    public Object returnType;

    public Parameter[] parameters;

}
