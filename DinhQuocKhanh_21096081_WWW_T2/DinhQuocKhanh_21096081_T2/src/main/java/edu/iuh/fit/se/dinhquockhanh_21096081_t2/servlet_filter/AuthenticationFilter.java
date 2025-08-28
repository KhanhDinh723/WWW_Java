package edu.iuh.fit.se.dinhquockhanh_21096081_t2.servlet_filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: Khánh Đinh
 * Date:   8/28/2025
 * Time:   7:51 PM
 */@WebFilter("/hello-servlet") // chỉ cho HelloServlet đi qua
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(">>> AuthenticationFilter initialized!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String user = request.getParameter("user");
        if("admin".equals(user)) {
            System.out.println(">>> Authentication passed: " + user);
            chain.doFilter(request, response);
        }else {
            System.out.println(">>> Authentication failed: " + user);
            PrintWriter out = response.getWriter();
            out.println("<h3>Access Denied: You must login as admin! </h3>");;
        }
    }

    @Override
    public void destroy() {
        System.out.println(">>> AuthenticationFilter destroyed!");
    }
}
