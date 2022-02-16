package com.example.item;

import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {

    @Setter(onMethod_ = @Autowired)
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void contextLoad(){
        // redisTemplate 操作不同的数据类型
        // opsForValue 操作字符串 类似String
        // opsForList 操作List 类似List
        // opsForSet
        // opsForHash
        // opsForGeo
        // opsForHyperLogLog

        // 获取redis的连接对象
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();
        redisTemplate.opsForValue().set("mykey","aaaaaaaa");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }

}
