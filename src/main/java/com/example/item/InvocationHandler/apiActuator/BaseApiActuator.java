package com.example.item.InvocationHandler.apiActuator;

import com.example.item.InvocationHandler.annotation.RemoteField;
import com.example.item.InvocationHandler.annotation.RemoteMethod;
import com.example.item.InvocationHandler.entity.ApiInfo;
import com.example.item.zrExam.baiduIdCard.GsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 开始执行接口数据转化
     *
     * @param method 接口方法
     * @param args   接口参数
     * @return object
     */
    public Object execute(Method method, Object[] args) {
        // 获取方法参数
        ApiInfo apiInfo = this.getApiInfo(method);
        Object o = convertRequest(apiInfo, args);
        System.out.println(o);
        return null;
    }

    /**
     * 获取API接口参数
     *
     * @param method 接口方法
     * @return ApiInfo
     */
    private ApiInfo getApiInfo(Method method) {
        final ApiInfo apiInfo = new ApiInfo();
        if (method.isAnnotationPresent(RemoteMethod.class)) {
            RemoteMethod remoteMethodAnnotation = method.getAnnotation(RemoteMethod.class);
            apiInfo.httpMethod = remoteMethodAnnotation.httpMethod();
            apiInfo.method = method;
            apiInfo.url = remoteMethodAnnotation.url();
        }
        apiInfo.returnType = method.getReturnType();
        apiInfo.parameters = method.getParameters();
        apiInfo.methodName = method.getName() + "#" + method.getReturnType().getName();
        return apiInfo;
    }

    public Object convertRequest(ApiInfo apiInfo, Object[] args) {
        Object[] newArgs = new Object[args.length];
        Class<?>[] parameterTypes = apiInfo.getMethod().getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            Field[] declaredFields = parameterTypes[i].getDeclaredFields();
            Object arg = args[i];
            for (Field declaredField : declaredFields) {
                if (declaredField.isAnnotationPresent(RemoteField.class)) {
                    arg = arg.toString().replace(declaredField.getName() + "=", declaredField.getDeclaredAnnotation(RemoteField.class).value() + "=");
                }
            }
            newArgs[i] = arg;
        }
        Parameter[] parameters = apiInfo.getMethod().getParameters();
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < parameters.length; i++) {
            map.put(parameters[i].getName(), newArgs[i]);
        }
        return GsonUtils.toJson(map);
    }

    public Object convertResponse(Object o) {
        return o;
    }

}
