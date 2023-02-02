package com.example.item.aspect;

import com.example.item.domain.annation.AnnationTest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
@Aspect
public class AspectTest {

    @Pointcut( value=" @annotation(com.example.item.domain.annation.AnnationTest)")
    public void aopTest() {
    }

    @Around("aopTest()")
    public Object doReportQueryPointAspect(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("测试进入了");
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        Field[] declaredFields = targetMethod.getReturnType().getDeclaredFields();
        for(Field field:declaredFields){
            if(field.isAnnotationPresent(AnnationTest.class)){
                field.setAccessible(true);
            }
        }
        AnnationTest annationTest = targetMethod.getAnnotation(AnnationTest.class);
        System.out.println(annationTest.testCode());
        return pjp.proceed();
    }
}
