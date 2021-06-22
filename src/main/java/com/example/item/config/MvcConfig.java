package com.example.item.config;

import com.example.item.aspect.CurrentLimitInterceptor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Setter(onMethod_ = @Autowired)
    private CurrentLimitInterceptor currentLimitInterceptor;

    /**
     * 重写接口中的addInterceptors方法，添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(currentLimitInterceptor); //这里表示对所有/hello的路径进行拦截
    }

}
