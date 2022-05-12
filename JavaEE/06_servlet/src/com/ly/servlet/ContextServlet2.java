package com.ly.servlet; /**
 * @Author : Ly
 * @Date : 2022/4/25
 * @Description :
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ContextServlet2", value = "/ContextServlet2")
public class ContextServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        System.out.println("前" + servletContext.getAttribute("name"));
        // 3、ServletContext是一个域对象。【不是保存到web.xml的<context-param> 里面】
        servletContext.setAttribute("name","ly");
        System.out.println("后" + servletContext.getAttribute("name"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
