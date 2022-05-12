package com.ly.servlet; /**
 * @Author : Ly
 * @Date : 2022/4/26
 * @Description :
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ForwardC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("经过了ForwardC");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/a/b/c.html");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
