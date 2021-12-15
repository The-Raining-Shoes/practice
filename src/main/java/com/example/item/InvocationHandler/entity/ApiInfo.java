package com.example.item.InvocationHandler.entity;

import com.example.item.InvocationHandler.annotation.RemoteMethod;
import lombok.Data;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Data
public class ApiInfo {

    public String urlMethod;

    public RemoteMethod.HttpMethod httpMethod;

    public Parameter[] parameters;

    public Method method;


}
