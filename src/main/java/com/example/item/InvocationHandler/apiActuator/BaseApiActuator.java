package com.example.item.InvocationHandler.apiActuator;

import com.example.item.InvocationHandler.annotation.RemoteField;
import com.example.item.InvocationHandler.annotation.RemoteMethod;
import com.example.item.InvocationHandler.entity.ApiInfo;
import com.example.item.zrExam.baiduIdCard.GsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.client.RestTemplate;

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
        long startMillis = System.currentTimeMillis();
        // 获取方法参数
        ApiInfo apiInfo = this.getApiInfo(method);
        Object requestObj = convertRequest(apiInfo, args);
        Object executeObj = null;
        Object rspObj = null;
        try {
            executeObj = executeMethod(apiInfo, restTemplate, requestObj);
            rspObj = convertResponse(apiInfo, executeObj);
            this.apiLog(startMillis, rspObj);
            this.apiCache(rspObj);
            return rspObj;
        } catch (Exception e) {
            Map<String, Object> rspMap = new HashMap<>(4);
            rspMap.put("executeObj", executeObj);
            rspMap.put("convertResponse", rspObj);
            rspMap.put("rspObj", rspObj);
            rspMap.put("exception", ExceptionUtils.getStackTrace(e));
            this.apiLog(rspMap);
            throw e;
        }
    }

    private void apiCache(Object rspObj) {

    }

    private void apiLog(Object... object) {

    }

    /**
     * 执行方法
     *
     * @param apiInfo      接口信息
     * @param restTemplate 请求体
     * @param o            请求体
     * @return obj
     */
    private Object executeMethod(ApiInfo apiInfo, RestTemplate restTemplate, Object o) {
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
        Parameter[] parameters = apiInfo.getMethod().getParameters();
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < parameters.length; i++) {
            String[] newFiled = new String[parameters.length];
            if (parameters.getClass().isAnnotationPresent(RemoteField.class)) {
                newFiled[i] = parameters[i].getAnnotation(RemoteField.class).value();
            } else {
                newFiled[i] = parameters[i].getName();
            }
            map.put(newFiled[i], args[i]);
        }
        return GsonUtils.toJson(map);
    }

    public Object convertResponse(ApiInfo apiInfo, Object o) {
        return o;
    }

    private String getObjStr(Object obj) {
        if (obj != null) {
            if (BeanUtils.isSimpleProperty(obj.getClass())) {
                return obj.toString();
            } else if (obj instanceof Exception) {
                return ExceptionUtils.getStackTrace((Throwable) obj);
            } else {
                return obj.toString();
            }
        }
        return null;
    }

}
