//package com.example.item.security;
//
//import com.example.item.domain.dto.Result;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
///**
// * 退出成功处理器
// */
//public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
//
//    @Override
//    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//            throws IOException {
//        response.setStatus(HttpServletResponse.SC_OK);
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
//        response.getWriter().write(new Result<>("").json());
//    }
//
//}