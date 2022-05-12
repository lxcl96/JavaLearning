package com.ly.servlet;

import com.ly.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author : Ly
 * @Date : 2022/4/28
 * @Description :
 */
public class ShowStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数

        //发sql语句查询sql信息

        //保存数据结果（学生信息）到request彧中
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int t = i + 1;
            students.add(new Student(t,"name" + t,18 + t,"phone" + t));
        }
        req.setAttribute("stuList",students);
        //请求转发到showStudent.jsp
        req.getRequestDispatcher("/showStudent.jsp").forward(req,resp);
        System.out.println("请求转发到showStudent.jsp");
    }
}
