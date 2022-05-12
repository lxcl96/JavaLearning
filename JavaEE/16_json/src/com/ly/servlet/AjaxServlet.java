package com.ly.servlet;

import com.google.gson.Gson;
import com.ly.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author : Ly
 * @Date : 2022/5/11
 * @Description :
 */
public class AjaxServlet extends BaseServlet{

    protected void javascriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InterruptedException {
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("ajax请求!");
        Person person = new Person(1, "哈哈哈");

        Thread.sleep(3000);
        //转化为json格式传递给前段
        Gson gson = new Gson();
        String personJson = gson.toJson(person);

        //返回给客户端
        resp.getWriter().write(personJson);
    }

    protected void JQAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InterruptedException {
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("JQ ajax请求!");
        Person person = new Person(1, "哈哈哈");

        //Thread.sleep(3000);
        //转化为json格式传递给前段
        Gson gson = new Gson();
        String personJson = gson.toJson(person);

        //返回给客户端
        resp.getWriter().write(personJson);
    }

    //$.serialize()方法
    protected void JQSerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("JQ ajax请求!  $.serialize()方法");
        Enumeration<String> parameterNames = req.getParameterNames();
        System.out.println("客户端传递来的参数");
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String[] parameterValues = req.getParameterValues(name);
            for (int i = 0; i < parameterValues.length; i++) {
                System.out.println(name + "=" + parameterValues[i]);
            }
        }
    }
}
