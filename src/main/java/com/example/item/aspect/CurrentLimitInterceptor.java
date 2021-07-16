package com.example.item.aspect;

import com.example.item.domain.entity.TUrlLimiter;
import com.example.item.domain.jdbc.BeanJdbcTemplate;
import com.example.item.utils.CheckUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class CurrentLimitInterceptor implements HandlerInterceptor {

    @Setter(onMethod_ = @Autowired)
    private BeanJdbcTemplate beanJdbcTemplate;

    @Setter(onMethod_ = @Autowired)
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String querySql = "select * from t_url_limiter where url = ? ";
        TUrlLimiter tUrlLimiter = beanJdbcTemplate.queryForBean(TUrlLimiter.class, querySql, request.getRequestURI());
        if (CheckUtil.isNotBlank(tUrlLimiter)) {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String format = df.format(new Date());
            RedisAtomicLong entityIdCounter = new RedisAtomicLong(request.getRequestURI() + format, Objects.requireNonNull(redisTemplate.getConnectionFactory()));
            entityIdCounter.expire(1, TimeUnit.SECONDS);
            long increment = entityIdCounter.getAndIncrement() + 1;
            System.out.println(increment + "/" + tUrlLimiter.getNumPerSec() + "-" + format);
            if (increment > tUrlLimiter.getNumPerSec()) {
                System.out.println("系统繁忙");
                if (CheckUtil.isNotBlank(response)) {
                    response.setStatus(429);
                }
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }

}
