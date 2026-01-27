package com.example.ex05.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@WebFilter("/sercure/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) servletRequest;
        HttpServletResponse rs = (HttpServletResponse) servletResponse;
        HttpSession session = rq.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("user") !=null);
        if(loggedIn){
            filterChain.doFilter(rq,rs);
        } else rs.sendRedirect(rq.getContextPath() +"/login.jsp");
    }
}
