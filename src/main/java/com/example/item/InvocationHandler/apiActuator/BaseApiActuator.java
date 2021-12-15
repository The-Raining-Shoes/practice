package com.example.item.InvocationHandler.apiActuator;

import com.example.item.InvocationHandler.annotation.RemoteMethod;
import com.example.item.InvocationHandler.entity.ApiInfo;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class BaseApiActuator implements InvocationHandler {

    public final RestTemplate restTemplate;
    public final String name;
    public final String password;

    @Setter
    public StringRedisTemplate stringRedisTemplate;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        return this.execute(method, args);
    }

    public Object execute(Method method, Object[] args) {
        if (method.getReturnType().getName().equals("void") || !method.isAnnotationPresent(RemoteMethod.class)) {
            return null;
        }
        ApiInfo apiInfo = this.getApiInfo(method);
        return null;
    }

    private ApiInfo getApiInfo(Method method) {
        return null;
    }

    public Object convertRequest(Object[] o) {
        return o;
    }

    public Object convertResponse(Object o) {
        return o;
    }

}
