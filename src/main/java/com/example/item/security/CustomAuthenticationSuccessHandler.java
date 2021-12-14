//package com.example.item.security;
//
//import com.example.item.domain.dto.Result;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
///**
// * 认证成功处理器
// */
//public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
//                                        HttpServletResponse httpServletResponse,
//                                        Authentication authentication) throws IOException {
//        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
//        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.toString());
//        httpServletResponse.getWriter().write(new Result<>(authentication).json());
//    }
//
//}