package com.ly.servlet;

import com.ly.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/5/7
 * @Description : Cookie演示
 */
public class CookieServlet extends BaseServlet{
    //创建cookie
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setCharacterEncoding("utf-8");
        //1、创建对象
        Cookie cookie = new Cookie("k1", "v1");
        //2、通知客户端保存cookie
        resp.addCookie(cookie);
        resp.getWriter().write("cookie创建成功!");
    }

    //获取cookie
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = null;
        Cookie k1 = CookieUtils.getCookie(req, "k1");
        if (k1 != null){
            str ="找到了想要的cookie";
        } else {
            str = "没找到想要的cookie";
        }
        resp.getWriter().write(str);
    }

    //修改cookie的值
    protected void amendCookieValue(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方法1、创建一个要修改的同名的Cookie对象
        Cookie cookie = new Cookie("k1", "v2");
        resp.addCookie(cookie);
        resp.getWriter().write("cookie值修改成功！");
    }

    //修改cookie的值
    protected void alertCookieValue(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方法2、使用cookie的setValue()方案
        Cookie k1 = CookieUtils.getCookie(req, "k1");
        k1.setValue("k3");
        resp.addCookie(k1);
        resp.getWriter().write("cookie值修改成功！");
    }

    //cookie有效性设置
    protected void cookieLifeDefault(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取k1的cookie生命周期值
        Cookie k1 = CookieUtils.getCookie(req, "k1");
        resp.getWriter().write("k1的生命周期默认为，k1.getMaxAge=" + k1.getMaxAge());
    }
    //cookie立即删除
    protected void cookieLifeDel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取k1的cookie生命周期值
        Cookie k1 = CookieUtils.getCookie(req, "k1");
        k1.setMaxAge(0);
        resp.addCookie(k1);
        resp.getWriter().write("k1已经被删除，k1.getMaxAge=" + k1.getMaxAge());
    }
    //cookie 30秒后被删除
    protected void cookieDelAfter10s(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取k1的cookie生命周期值
        Cookie k1 = CookieUtils.getCookie(req, "k1");
        k1.setMaxAge(30);
        resp.addCookie(k1);
        resp.getWriter().write("k1将在30后被删除，k1.getMaxAge=" + k1.getMaxAge());
    }

    //设置cookie的工程路径
    protected void cookiePath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("pathKey", "pathValue");
        cookie.setPath(req.getContextPath() + "/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("cookie pathKey已经被创建，显示地址为：" + req.getContextPath() + "/abc");
    }

    //用户的登录-  记住用户名
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Cookie usernameCookie = new Cookie("username", username);
        usernameCookie.setMaxAge(60 * 60 * 24);
        resp.addCookie(usernameCookie);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);

    }


}
