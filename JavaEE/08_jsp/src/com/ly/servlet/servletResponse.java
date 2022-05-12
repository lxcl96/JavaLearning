package com.ly.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author : Ly
 * @Date : 2022/4/27
 * @Description : servlet回传数据给前段 【特别麻烦】
 */
public class servletResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //回传一个页面 需要同时设置服务端和客户端字符集编码
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Context-type","utf-8");

        //resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<!DOCTYPE html>");
        writer.write("<html lang=\"en\">\n");
        writer.write("<head>");
        writer.write("    <meta charset=\"UTF-8\">");
        writer.write("    <title>Title</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("    <h1>使用servlet回传数据!</h1>");
        writer.write("</body>");
        writer.write("</html>");
    }
}
