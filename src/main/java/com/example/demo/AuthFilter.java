package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(2)
public class AuthFilter extends OncePerRequestFilter {

    private final LoginSuccessHandler loginSuccessHandler;

    public AuthFilter(@Autowired LoginSuccessHandler loginSuccessHandler) {
        this.loginSuccessHandler = loginSuccessHandler;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().equals("/login") && request.getMethod().equals("POST")) {
            request.getSession(true).setAttribute("loggedIn", true);
            loginSuccessHandler.onAuthenticationSuccess(request, response);
        }
        filterChain.doFilter(request, response);
    }
}
