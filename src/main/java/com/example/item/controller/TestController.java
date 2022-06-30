package com.example.item.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import com.alibaba.excel.EasyExcel;
import com.example.item.domain.dto.StaffUploadMouldFileDTO;
import com.example.item.domain.dto.TestDTO;
import lombok.NonNull;
import lombok.Setter;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
    public String test3(HttpServletResponse response) {
        File zip = null;
        try {
            zip = ZipUtil.zip(File.createTempFile("test-zip", ".zip"), false,
                    FileUtil.file("d:/线上部2021年数据安全应急演练报告-网厅系统.doc"),
                    FileUtil.file("d:/模板.xlsx")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (zip != null) {
            try (FileInputStream fileInputStream = new FileInputStream(zip)) {
                response.reset();
                response.setContentType("application/octet-stream;charset=utf-8");
                response.setHeader("Content-Disposition",
                        "attachment;filename=\"" + URLEncoder.encode("testZip.zip", "utf-8") + "\"");
                OutputStream outputStream = response.getOutputStream();
                outputStream.write(IOUtils.toByteArray(fileInputStream));
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "hello";
    }

    @GetMapping(value = "/testAopMethod")
    public String testAopMethod(@NonNull String testCode) {
        System.out.println("test".equalsIgnoreCase(testCode));
        System.out.println(testCode);
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
