package com.example.item;

import com.example.item.domain.entity.TUrlLimiter;
import com.example.item.domain.jdbc.BeanJdbcTemplate;
import lombok.Setter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class TestRedisTemplate {

    @Setter(onMethod_ = @Autowired)
    private RedisTemplate<Object, Object> redisTemplate;

    @Setter(onMethod_ = @Autowired)
    private BeanJdbcTemplate beanJdbcTemplate;

    @Test
    public void test() {
        redisTemplate.opsForValue().set("", "", 1, TimeUnit.SECONDS);
    }

    @Test
    public void testCode() {
        String querySql = "select * from t_url_limiter";
        List<TUrlLimiter> tUrlLimiters = beanJdbcTemplate.queryForList(TUrlLimiter.class, querySql);
        System.out.println(tUrlLimiters);
    }

}
