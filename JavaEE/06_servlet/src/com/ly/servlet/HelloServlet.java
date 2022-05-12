package com.ly.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author : Ly
 * @Date : 2022/4/24
 * @Description :
 */
//1、实现servlet接口
public class HelloServlet implements Servlet{

    public HelloServlet() {
        System.out.println("1、执行Servlet构造器方法");
    }

    /*
    ServletConfig作用：
        1、可以获取Servlet在web.xml中的别名即 <servlet-name></servlet-name>的值
        2、获取初始化参数 init-param
        3、获取ServletContext
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println(" 2、执行init初始化方法");
        System.out.println("ServletConfig 可以获取Servlet在web.xml中的别名 ，即" + servletConfig.getServletName());
        //获取value <param-value>
        System.out.println("ServletConfig 可以获取Servlet 在[在web.xml中配置]获取初始化参数 init-param ，即" + servletConfig.getInitParameter("name"));
        //获取名称 <param-name>
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            System.out.println(initParameterNames.nextElement());
        }
        System.out.println("ServletConfig 可以获取Servlet 获取ServletContext对，即" + servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用来出来请求和响应的。即只要访问HelloServlet程序，就会访问这个方法。
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        System.out.println("***helloServlet被访问了。");
        System.out.println("3、执行service方法");
        //获取请求的类型  分post和get
        String method = ((HttpServletRequest) servletRequest).getMethod();
        System.out.println("请求的方法为：" + method);

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println(" 4、执行destroy销毁方法");
    }


}
