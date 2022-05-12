package com.ly.servlet; /**
 * @Author : Ly
 * @Date : 2022/4/25
 * @Description :
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ServletContext对象的作用：
        //  1、获取web.xml中配置的上下文参数 context-param
        //  2、获取当前的工程路径   /工程名
        //  3、获取工程部署后在服务器磁盘上的绝对路径。
        //  4、像Map一样存储数据。
        ServletContext servletContext = getServletContext();
        System.out.println("上下文参数" + servletContext.getInitParameter("userName"));
        System.out.println("获取当前的工程路径   /工程名" + servletContext.getContextPath());

        /*
          此处获取能获取绝对路径的原因是：
            idea启动tomcat时，会把tomcat部分运行文件拷贝到指定目录： 即CATALINA_BASE
            这个路径里面 的conf/Catalina/localhost/06_servlet_war_exploded.xml 这个就是我们说部署工程的配置文件
            里面就配置了网页访问的工程路径名 /06_servlet_war_exploded 【和文件名一样】
            和其实际对应的物理地址：    docBase="D:\JavaWork\JavaWeb\out\artifacts\06_servlet_war_exploded"
            所有可以得到实际路径。

            作用：可以获取部署在服务器上的静态文件资源
            如获取wlq.png
            servletContext.getRealPath("/imgs/wlq.png")
         */
        //获取工程部署后在服务器磁盘上的绝对路径 写上 / ,因为 / 就表示当前工程路径,对应web目录就可以了
        System.out.println("获取工程部署后在服务器磁盘上的绝对路径" + servletContext.getRealPath("/"));
        System.out.println("获取工程下wlq.png的绝对路径是" + servletContext.getRealPath("/imgs/wlq.png"));





    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
