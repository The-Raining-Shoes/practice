package com.example.item.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class CurrentLimitInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        String querySql = "select * from t_url_limiter where url = ? ";
//        TUrlLimiter tUrlLimiter = beanJdbcTemplate.queryForBean(TUrlLimiter.class, querySql, request.getRequestURI());
//        if (CheckUtil.isNotBlank(tUrlLimiter)) {
//            String format = df.format(new Date());
//            RedisAtomicLong entityIdCounter = new RedisAtomicLong(request.getRequestURI() + format, Objects.requireNonNull(redisTemplate.getConnectionFactory()));
//            entityIdCounter.expire(1, TimeUnit.SECONDS);
//            long increment = entityIdCounter.getAndIncrement() + 1;
//            System.out.println(increment + "/" + tUrlLimiter.getNumPerSec() + "-" + format);
//            if (increment > tUrlLimiter.getNumPerSec()) {
//                System.out.println("系统繁忙");
//                if (CheckUtil.isNotBlank(response)) {
//                    response.setStatus(429);
//                }
//                return false;
//            }
//        }
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
