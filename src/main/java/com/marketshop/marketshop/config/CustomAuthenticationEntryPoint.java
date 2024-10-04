package com.marketshop.marketshop.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//
//        // 인증되지 않은 사용자가 리소스를 요청할 경우 Unauthorized 에러 발생
//        // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//
//        // 로그 추가
//        System.out.println("Access Denied: " + authException.getMessage());
//        response.sendRedirect("/members/login"); // 인증되지 않은 사용자를 로그인 페이지로 리디렉션
//    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("{ \"error\": \"Unauthorized access\" }");
    }
}
