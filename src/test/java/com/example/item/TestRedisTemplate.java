package com.example.item;

import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedisTemplate {

    @Setter(onMethod_ = @Autowired)
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void test() {
//        redisTemplate.boundValueOps("testCode").set(123);
        redisTemplate.opsForValue().set("", "", 1, TimeUnit.SECONDS);
    }

}
