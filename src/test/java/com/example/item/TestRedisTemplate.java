package com.example.item;

import com.example.item.domain.entity.TUrlLimiter;
import com.example.item.domain.jdbc.BeanJdbcTemplate;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
public class TestRedisTemplate {

    @Setter(onMethod_ = @Autowired)
    private RedisTemplate<Object, Object> redisTemplate;

    @Setter(onMethod_ = @Autowired)
    private BeanJdbcTemplate beanJdbcTemplate;

    @Test
    public void test() {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(3000);
        simpleClientHttpRequestFactory.setReadTimeout(100);
        RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory);
        System.out.println(redisTemplate.boundListOps("").size());
        while (true) {
            Object o = redisTemplate.boundListOps("").leftPush("1");
            if (o != null) {
                System.out.println(o);
            }else{
                break;
            }
        }
    }

    @Test
    public void testCode() {
        String querySql = "select * from t_url_limiter";
        List<TUrlLimiter> tUrlLimiters = beanJdbcTemplate.queryForList(TUrlLimiter.class, querySql);
        System.out.println(tUrlLimiters);
    }

}
