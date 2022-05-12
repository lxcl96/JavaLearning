package com.ly.servlet; /**
 * @Author : Ly
 * @Date : 2022/4/26
 * @Description :
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //检查请求的参数
        String username = request.getParameter("username");
        System.out.println("servlet1中填写材料 " + username);

        //使用请求的 域数据 给材料盖章，并传递到servlet2中
        request.setAttribute("key","柜台1的章");
        //设置servlet2转发路径  即工程路径
        //  “必须为 / 开头 其中 / 就表示 http://ip:port/工程名/” 即映射到IDEA （左边的 ）web目录
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/s2");

        //找到了去servlet2的路，就走吧 参数就是自身的request 和 response
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
