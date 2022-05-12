package com.ly.servlet;

import com.google.code.kaptcha.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/5/9
 * @Description :
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-type","text/html;charset=utf-8");
        //获取用户名
        String username = req.getParameter("username");
        String verifyCode = req.getParameter("verifyCode");
        //获取session的验证码后马上删除此session中的验证码
        String session_key = (String)req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!(session_key != null && session_key.equalsIgnoreCase(verifyCode))) {
            resp.getWriter().write("验证码不正确，请重新输入!");
            return;
        }
        System.out.println("保存到数据库！1");
        resp.sendRedirect(req.getContextPath() + "/ok.jsp");
    }
}
