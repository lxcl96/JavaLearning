package com.ly.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/5/9
 * @Description : Session测试
 */
public class SessionServlet extends BaseServlet{
    //创建和获取session
    public void getSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //只看有没有session 不创建 传参数false request.getSession(false);
        HttpSession session = request.getSession();
        response.getWriter().write("session = " +  session + "<br/>" + "isNew()=" + session.isNew() + "<br/>session.id=" + session.getId());
    }

    //session域存储数据
    public void SessionDataSet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //只看有没有session 不创建 传参数false request.getSession(false);
        HttpSession session = request.getSession();
        session.setAttribute("k1","v1");
        //保存到session域了，但是不用和cookie一样需要另外返回客户端，直接用
    }

    //session域存储数据获取
    public void SessionDataGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //只看有没有session 不创建 传参数false request.getSession(false);
        HttpSession session = request.getSession();
        Object k1 = session.getAttribute("k1");
        response.getWriter().write("session的key1的值为：" + k1);
    }

    //session会话超时及配置
    public void SessionLife(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //只看有没有session 不创建 传参数false request.getSession(false);
        HttpSession session = request.getSession();
        response.getWriter().write("session默认的会话过期时间为：" + session.getMaxInactiveInterval());
    }

    //session会话3s后删除
    public void SessionDelAfter3s(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //只看有没有session 不创建 传参数false request.getSession(false);
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(3);
    }

    //session会话马上删除
    public void SessionDelNow(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //只看有没有session 不创建 传参数false request.getSession(false);
        HttpSession session = request.getSession();
        session.invalidate();
    }
}
