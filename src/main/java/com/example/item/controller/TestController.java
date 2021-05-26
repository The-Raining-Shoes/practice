package com.example.item.controller;

import com.example.item.domain.dto.TestDTO;
import com.example.item.domain.entity.GoodsInfo;
import com.example.item.domain.repository.res.GoodsInfoRepository;
import com.example.item.service.TestService;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Setter(onMethod_ = @Autowired)
    private TestService testService;
    @Setter(onMethod_ = @Autowired)
    private GoodsInfoRepository goodsInfoRepository;

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

    @GetMapping(value = "/testJpa")
    public String testJpa(HttpServletResponse response) {
        List<GoodsInfo> list = goodsInfoRepository.findAll();
        System.out.println(list);
        try {
            response.sendRedirect("https://www.baidu.com/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "hello";
    }

    @GetMapping(value = "/testDoubleParam")
    public String testDoubleParam(Object param) {
        System.out.println(param instanceof Integer);
        System.out.println(param instanceof String);
        return param.toString();
    }
}
