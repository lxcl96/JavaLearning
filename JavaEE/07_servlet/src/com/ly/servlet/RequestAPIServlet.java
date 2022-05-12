package com.ly.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/4/25
 * @Description :
 */
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
       2、HTTPServletRequest类的常用方法
           1、getRequestURI()    获得请求的资源地址/路径
           2、getRequestURL()    获得请求的统一资源定位符，即绝对路径
           3、getRemoteHost()    获取客户端ip地址
           4、getHeader()        获取请求头
           5、getParameter()     获取请求的参数
           6、getParameterValues()     获取请求的参数，多个值使用
           7、getMethod()        获取请求的方式post or get
           8、setAttribute(key,value)     设置域数据
           9、getAttribute(key)     获取域数据
           10、getRequestDispatcher()    获取请求转发对象
         */
        ServletContext servletContext = getServletContext();
//        System.out.println("看看HttpServletRequest.setAttribute(key,value)设置的值是不是 ServletContext也可以取到 ---"
//                + servletContext.getAttribute("name"));
        //System.out.println("1、getRequestURI()    获得请求的资源地址/路径    " + req.getRequestURI());
        //System.out.println("2、getRequestURL()    获得请求的统一资源定位符，即绝对路径    " + req.getRequestURL());
        //System.out.println("3、getRemoteHost()    获取客户端ip地址    " + req.getRemoteHost());
        //System.out.println("4、getHeader()        获取请求头    " + req.getHeader("User-Agent"));
        //System.out.println("5、getParameter()     获取请求的参数    " + req.getParameter("name"));

        //如果参数为中文，可能会乱码 所以需要设置一下  doGet不需要,doPost需要
        req.setCharacterEncoding("utf-8"); //必须要放在最开始位置 ，如果
        String[] names = req.getParameterValues("name");
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("6、getParameterValues()     获取请求的参数，多个值使用    " + req.getParameterValues("name"));
        //System.out.println("7、getMethod()        获取请求的方式post or get    " + req.getMethod());
        //System.out.println("8、setAttribute(key,value)     设置域数据    " );
        //req.setAttribute("name","ly");
        //System.out.println("9、getAttribute(key)     获取域数据    " + req.getAttribute("name"));
//        System.out.println("看看HttpServletRequest.setAttribute(key,value)设置的值是不是 ServletContext也可以取到 ---"
//                + servletContext.getAttribute("name"));
        //System.out.println("10、getRequestDispatcher()    获取请求转发对象    " + req.getRequestDispatcher());

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post方法 中文不处理会乱码 注意，如果设置编码 不是放在最开始 是无效的
        //req.setCharacterEncoding("utf-8");

        String pwd = req.getParameter("pwd");
        System.out.println("密码 " + pwd);
        //post方法 中文不处理会乱码 注意:***必须要在获取参数前调用，所有的 getParameter getParameterValues
        req.setCharacterEncoding("utf-8");
        String[] names = req.getParameterValues("name");
        for (String name : names) {
            System.out.println("name " + name);
        }
    }
}
