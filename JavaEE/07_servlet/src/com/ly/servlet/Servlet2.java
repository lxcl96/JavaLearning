package com.ly.servlet; /**
 * @Author : Ly
 * @Date : 2022/4/26
 * @Description :
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //检查请求的参数
        String username = request.getParameter("username");
        System.out.println("serv2接受到在servlet1中填写材料 " + username);

        //检查servlet1的章
        Object key = request.getAttribute("key");
        System.out.println(key);
        if ("柜台1的章".equals(key)) {
            System.out.println("servlet1的章有效，我也盖章！");
            System.out.println("任务完成");
        } else {
            System.out.println("servlet1的章无效，出门左转，不送！");

        }
        //请求转发可以访问到保护目录  WEB-INF
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/b.html");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
