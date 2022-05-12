package com.ly.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/5/11
 * @Description :
 */
public class adminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 专门用于拦截请求，回应响应
     * @param servletRequest 是HttpServletRequest的父接口
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
        HttpSession session = servletRequest1.getSession();
        if (session.getAttribute("admin") == null) {
            servletResponse.getWriter().write("no have privilege! only admin!please login!");
        } else {
            System.out.println("hello,admin!");
            //过滤完成让程序继续执行   即放行
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
