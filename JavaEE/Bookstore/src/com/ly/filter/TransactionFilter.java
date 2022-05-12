package com.ly.filter;

import com.ly.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/5/11
 * @Description : 通过过滤器给所有的service层都加上事务管理 ，这样就不用一个一个写try-catch了
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            //把异常抛出给服务器 这样就可以在web.xml中跳转到对应错误码页面
            //e.printStackTrace();
            JdbcUtils.rollBackAndClose();

            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
