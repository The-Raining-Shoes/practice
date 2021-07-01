package com.example.item.controller;

import com.example.item.domain.dto.TestDTO;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
public class TestController {

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
}
