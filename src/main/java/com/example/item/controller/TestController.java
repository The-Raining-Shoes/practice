package com.example.item.controller;

import com.alibaba.excel.EasyExcel;
import com.example.item.domain.dto.StaffUploadMouldFileDTO;
import com.example.item.domain.dto.TestDTO;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/TestController")
public class TestController {

    @Setter(onMethod_ = @Autowired)
    private RedisTemplate<Object, Object> redisTemplate;

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

    @GetMapping(value = "/setSession")
    public void httpRequestTest(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().setAttribute("testSession", "123321");
    }

    @GetMapping(value = "/setSessionTwo")
    public void setSessionTwo(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().setAttribute("testSessionTwo", "123321");
    }

    @GetMapping(value = "/getSession")
    public void getSession() {
        ServletRequestAttributes s = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (s == null) {
            System.out.println("1");
        } else {
            Object testSession = s.getRequest().getSession().getAttribute("testSession");
            System.out.println(testSession);
        }
    }

    @GetMapping(value = "/someStuff")
    public void someStuff(HttpServletResponse response) {
        List<StaffUploadMouldFileDTO> list = new ArrayList<>();
        try {
            String name = URLEncoder.encode("人员信息导入模板.xlsx", StandardCharsets.UTF_8.name());
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
            EasyExcel.write(response.getOutputStream(), StaffUploadMouldFileDTO.class).sheet("sheet1").doWrite(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
