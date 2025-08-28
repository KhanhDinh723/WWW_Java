package edu.iuh.fit.se.dinhquockhanh_21096081_t2.servlet_filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.util.Date;

/**
 * Author: Khánh Đinh
 * Date:   8/28/2025
 * Time:   7:26 PM
 */
@WebFilter("/*") // áp dụng cho tất cả request
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(">>> LoggingFilter initialized!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(">>> Request received at: " + new Date());

        // cho request đi tiếp đến Servlet

        filterChain.doFilter(servletRequest,
                servletResponse);

        // sau khi Servlet xử lý xong → Filter vẫn bắt được response
        System.out.println("<<< Response sent at: " + new Date());


    }

    @Override
    public void destroy() {
        System.out.println(">>> LoggingFilter destroyed!");
    }
}
