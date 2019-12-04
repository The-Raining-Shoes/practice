package com.example.item.service;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.example.item.service.annation.AnnationTest;

import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.Signature;

@Component
@Aspect
public class AspectClass {
	
	@Pointcut("@annotation(com.example.item.service.annation.AnnationTest)")
	public void aopTest() {
	}
	
	
	@Around("aopTest()")
    public void doReportQueryPointAspect(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("测试进入了");
		Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod(); 
        AnnationTest annationTest = targetMethod.getAnnotation(AnnationTest.class);
        System.out.println(annationTest.testCode());
        pjp.proceed();
	}
}
