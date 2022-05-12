package com.ly.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author : Ly
 * @Date : 2022/4/26
 * @Description :
 */
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getOutputStream();
        //ISO-8859-1 默认字符集
        System.out.println("初始化字符集为：" + resp.getCharacterEncoding());

        //utf8就是unicode
        //设置字符集 为GBk可以显示，utf8不可以【因为设置的是服务器的字符集，浏览器默认是gbk】
        //resp.setCharacterEncoding("utf-8");

        //通过响应链 头部设置 请求头 为utf-8/
        //resp.setHeader("Content-Type","utf-8");
        //另一种方法  setContentType("utf-8")同时设置客户端和服务端编码，同时还设置了响应头
        //注意此方法，必须要在获取流对象前才会有效
        resp.setContentType("text/html; charset=utf-8");


        PrintWriter writer = resp.getWriter();
        writer.println("response 响应!");
        System.out.println("setContentType化字符集为：" + resp.getCharacterEncoding());
    }
}
