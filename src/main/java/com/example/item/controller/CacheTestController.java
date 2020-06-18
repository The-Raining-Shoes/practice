package com.example.item.controller;

import com.example.item.service.TestService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 缓存测试
 *
 * @author HXM
 * @date 2020年05月29日 16:07
 */
@RestController
@RequestMapping(value = "/cache")
public class CacheTestController {

    @Setter(onMethod_ = @Autowired)
    private TestService testService;

    @GetMapping(value = "/test")
    public String testCache(String testCode) {
        return testService.testCache(testCode);
    }

}
