package com.ly.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @Author : Ly
 * @Date : 2022/4/29
 * @Description : 接受前端发来的文件
 */
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理客户端发来的文件
        List<FileItem> list = null;

        //1、判断上传的数据是不是多段的数据
        if (!ServletFileUpload.isMultipartContent(req)) {
            System.out.println("不是多段的数据");
            return;
        }

        //2、创建DiskFileItemFactory对象,然后创建ServletFileUpload对象用于解析上传数据
        FileItemFactory FileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(FileItemFactory);

        //3、开始解析,得到每一个表单项的集合
        try {
            list = servletFileUpload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        //4、取出每个表单项，对于文件类型单独处理
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            FileItem next = (FileItem)iterator.next();
            if (!next.isFormField()) {
                //如果是文件，下载到d盘
                String fileName = next.getName();
                System.out.println("上传文件名为：" + fileName);
                try {
                    next.write(new File("d:\\" + fileName));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("普通表单项：" + next.getFieldName() + "=" + next.getString("utf-8"));
            }
        }
    }
}
