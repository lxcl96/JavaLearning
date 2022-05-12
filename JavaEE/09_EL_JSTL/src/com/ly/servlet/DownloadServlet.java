package com.ly.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @Author : Ly
 * @Date : 2022/4/29
 * @Description : 文件下载
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理客户端的文件下载
        ServletContext servletContext = getServletContext();

        //1、获取要下载的文件名
        String username = req.getParameter("username");
        String filename = req.getParameter("filename");
        System.out.println(username + " 要下载 " + filename);


        //4、设置返回头，告诉客户端服务器返回的数据类型文件 【放在最开始】
        resp.setHeader("Context-type",servletContext.getMimeType("/imgs/" + filename));
        //或者另一个方法    resp.setContentType("/imgs/" + filename);

        //5、设置返回头，告诉客户端服务器返回的数据 用于下载  【放在最开始】 ,可以判断浏览器类型
            //对文件名进行URL编码 防止出现乱码
        resp.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode("伍六七.png","utf-8"));


        //2、读取要下载的文件内容（通过ServletContext对象）
            //读取指定文件
        InputStream inputStream = servletContext.getResourceAsStream("/imgs/" + filename);
            //获取response输出流 用于写数据
        ServletOutputStream outputStream = resp.getOutputStream();


        //3、借助工具 把输入流文件数据 拷贝到输出流文件数据
        IOUtils.copy(inputStream,outputStream);


    }
}
