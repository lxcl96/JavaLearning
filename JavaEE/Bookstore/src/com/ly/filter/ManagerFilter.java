package com.ly.filter;

import com.ly.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/5/11
 * @Description : 后台过滤
 */
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //只允许管理员登陆
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        resp.setHeader("Content-type","text/html;charset=utf-8");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        User user = (User)req.getSession().getAttribute("user");
        if (user != null && "admin".equalsIgnoreCase(user.getUsername())) {
            filterChain.doFilter(servletRequest,servletResponse);
        } else if (user == null){
            resp.getWriter().write("<h5>请先登陆!</h5>");
        } else if (!"admin".equalsIgnoreCase(user.getUsername())){
            resp.getWriter().write("<h5>仅管理员可访问此页面!</h5>");
        }
    }

    @Override
    public void destroy() {

    }
}
