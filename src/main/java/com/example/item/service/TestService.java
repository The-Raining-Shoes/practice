package com.example.item.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Cacheable(value = "TEST_CODE", key = "#testCode")
    public String testCache(String testCode) {
        System.out.println(1);
        return testCode;
    }

    @CacheEvict(value = "TEST_CODE", key = "1")
    public String clearCache() {
        return "缓存已清除";
    }

}
