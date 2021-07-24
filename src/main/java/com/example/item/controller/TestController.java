package com.example.item.controller;

import com.example.item.domain.dto.TestDTO;
import com.example.item.utils.CusAccessObjectUtil;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/TestController")
public class TestController {

    @GetMapping(value = "/test")
    public String test() {
        return "hello";
    }

    @GetMapping(value = "/test3")
    public String test3() {
        return "hello";
    }

    @GetMapping(value = "/testAopMethod")
    public String testAopMethod(@NonNull String testCode) {
        System.out.println(testCode);
//        testService.tests();
        return "hello";
    }

    @PostMapping(value = "/testControllerAdvice")
    public String testControllerAdvice(@RequestBody TestDTO testClass) {
        System.out.println(testClass);
        return "hello";
    }

    @GetMapping(value = "/testDoubleParam")
    public String testDoubleParam(Object param) {
        System.out.println(param instanceof Integer);
        System.out.println(param instanceof String);
        return param.toString();
    }

    @GetMapping(value = "/httpRequestTest")
    public void httpRequestTest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String ipAddress = CusAccessObjectUtil.getIpAddress(httpServletRequest);
        // 请求真实ip地址
        System.out.println(ipAddress);
    }


}
