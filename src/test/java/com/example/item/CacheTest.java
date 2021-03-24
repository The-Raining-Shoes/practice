package com.example.item;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author HXM
 * @date 2021年03月11日 11:04
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CacheTest {

    @Test
    public void test() {
        testCache("1");
        testCache("2");
        testCache("1");
        testCache("3");
    }

    @Cacheable(value = {"test"}, key = "#code", condition = "#code!=null")
    public String testCache(String code) {
        System.out.println("方法进来了");
        System.out.println(code);
        return code;
    }

}
