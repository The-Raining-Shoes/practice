//package com.example.item.security;
//
//import org.springframework.http.MediaType;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
///**
// * 认证入口（未登录状态）
// */
//public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest httpServletRequest,
//                         HttpServletResponse httpServletResponse,
//                         AuthenticationException e) throws IOException {
//        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.toString());
//        httpServletResponse.getWriter().write("当前未存在登陆账号，请登陆后重试");
//    }
//
//}