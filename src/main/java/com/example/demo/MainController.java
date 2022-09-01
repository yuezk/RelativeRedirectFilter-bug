package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MainController {
    @GetMapping("/")
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession(true).getAttribute("loggedIn") != null) {
            response.setContentType("text/html");
            response.getWriter().println("<h1>Home page</h1>");
            response.getWriter().println("<a href=\"/login\">Go to login page</a>");
        } else {
            response.sendRedirect("/login");
        }
    }

    @GetMapping("/login")
    public void login(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Login page</h1>");
        response.getWriter().println("<form action=\"/login\" method=\"post\">");
        response.getWriter().println("<input type=\"submit\" value=\"Login with Kerberos\" />");
        response.getWriter().println("</form>");
    }

}
