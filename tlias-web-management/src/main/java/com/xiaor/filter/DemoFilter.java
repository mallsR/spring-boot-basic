package com.xiaor.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("DemoFilter init");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("DemoFilter destroy");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("DemoFilter doFilter");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
