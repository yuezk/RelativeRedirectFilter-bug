package com.example.demo;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler {

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // login success, redirect to the page that was requested
        response.sendRedirect("/");
    }
}
