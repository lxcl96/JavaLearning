package com.ly.servlet;

import javax.servlet.ServletConfig;
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
public class HelloServlet2 extends HttpServlet {
    /**
     * 处理get请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HttpServlet 的get方法");
        System.out.println(getServletConfig().getInitParameter("url"));
    }

    /**
     * 处理post请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HttpServlet 的post方法");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
        System.out.println("重新init方法必须要继承父类的init");
    }

}
