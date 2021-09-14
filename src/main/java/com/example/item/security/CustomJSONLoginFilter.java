package com.example.item.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义 JSON 登录
 */
@Slf4j
public class CustomJSONLoginFilter extends AbstractAuthenticationProcessingFilter {

    public CustomJSONLoginFilter(String defaultFilterProcessesUrl) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl, HttpMethod.POST.name()));
        this.setAuthenticationSuccessHandler(new CustomAuthenticationSuccessHandler());
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        System.out.println("12332132131312");
        MyAuthentication myAuthentication = new MyAuthentication();
        List<CustomGrantedAuthority> list = new ArrayList<>();
        CustomGrantedAuthority customGrantedAuthority = new CustomGrantedAuthority();
        customGrantedAuthority.setPrivCode("TEST_CODE");
        list.add(customGrantedAuthority);
        myAuthentication.setAuthorities(list);
        return myAuthentication;
    }

}
