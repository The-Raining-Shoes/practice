package com.example.item.service;

import com.example.item.domain.annation.AnnationTest;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @AnnationTest(testCode = "测试数据")
    public void tests() {
        System.out.println("切面测试");
    }

    public String testCache(String testCode) {
        return testCode;
    }
}
