package com.example.item.InvocationHandler.apiActuator;

import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class BaseApiActuator implements InvocationHandler {

    private final ThreadLocal<Method> runMethod = new ThreadLocal<>();

//    @Setter(onMethod_ = @Autowired)
//    private RedisTemplate<String, Object> redisTemplate;

    public String name;
    public String password;
    public RestTemplate restTemplate;

    public BaseApiActuator(RestTemplate restTemplate, String name, String password) {
        this.name = name;
        this.password = password;
        this.restTemplate = restTemplate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        runMethod.set(method);
        return this.execute(method, args);
    }

    public Object execute(Method method, Object[] args) {
        System.out.println(method.getName());
        Parameter[] parameters = method.getParameters();
        System.out.println(Arrays.toString(args));
        for (Parameter parameter : parameters) {
            System.out.println(Arrays.toString(parameter.getClass().getDeclaredFields()));
        }
        return null;
    }

    public Object convertRequest(Object[] o) {
        return o;
    }

    public Object convertResponse(Object o) {
        return o;
    }

}
