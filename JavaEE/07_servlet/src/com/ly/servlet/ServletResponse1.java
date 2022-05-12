package com.ly.servlet; /**
 * @Author : Ly
 * @Date : 2022/4/26
 * @Description :
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletResponse1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("到此一游1！");

        //重定向方法1
        //设置响应状态码 和响应头，返回新地址
        //response.setStatus(302);
        //response.setHeader("location","http://localhost:8080/07_servlet/sr2");
        //response.setHeader("location","/07_servlet/WEB-INF/b.html");

        //重定向方法2
        //设置响应状态码 和响应头，返回新地址  http://localhost:8080/07_servlet/sr2
        response.sendRedirect("/07_servlet/sr2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
