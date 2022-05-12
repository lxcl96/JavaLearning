package com.ly.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author : Ly
 * @Date : 2022/4/30
 * @Description : servlet基类，定义公共方法
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取隐藏域字段
        String action = req.getParameter("action");
        //System.out.println("action=" + action);
        //每加一个功能就要写一个if判断，比较麻烦
        //解决方法：设置前端隐藏域的 value值和servlet处理的的方法名一致，借用反射原理 一步搞定
        //前段：<input type="hidden" name="action" value="register">

        //利用反射，动态处理前端请求
        //1、获取目标类的Class
        //Class<UserServlet> userServletClass = UserServlet.class;
        Class<? extends BaseServlet> aClass = this.getClass();
        //还可以这样
        //Class<UserServlet> userServletClass = this.getClass();
        try {
            //2、获取目标类实例
            //UserServlet userServlet = userServletClass.newInstance();
            //3、获取目标类指定方法
            Method declaredMethod = aClass.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //4、使用方法
            //System.out.println("通过反射调用方法!");
            declaredMethod.invoke(this,req,resp);
            //还可以这样
            //declaredMethod.invoke(this,req,resp);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
