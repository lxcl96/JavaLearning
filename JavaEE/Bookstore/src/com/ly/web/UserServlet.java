package com.ly.web;

import com.google.code.kaptcha.Constants;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ly.bean.User;
import com.ly.service.impl.UserServiceImpl;
import com.ly.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;


/**
 * @Author : Ly
 * @Date : 2022/4/30
 * @Description : 整合registerServlet.java和loginServlet.java 通过前端传回参数进行判断处理，借助前端的隐藏域传递
 *                       <input type="hidden" name="action" value="login">
 */
public class UserServlet extends BaseServlet {
    //和数据库打交道的就是DAO层，但是web层不能直接访问dao层，只能访问service层
    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    /**
     * 用户登录
     * @param request request请求
     * @param response response响应
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //用户登陆校验
        request.setCharacterEncoding("utf-8");
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //访问数据库 看看用户是否存在 如果存在再进行密码校验
        if (!userService.existUserName(username)) {
            System.out.println("该用户名不存在！" + username);
            request.setAttribute("msg","该用户名不存在！");
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            //返回登陆界面 ,如果直接返回login的servlet程序会导致死循环，因为参数没有发送变化总是不合法的
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
            return;
        }

        //如果用户名存在进行账号密码校验
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            System.out.println("登录密码错误，请检查！");
            request.setAttribute("msg","登录密码错误，请检查！");
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
            return;
        }
        //将用户数据 User保存在session中
        HttpSession session = request.getSession();
        session.setAttribute("user",loginUser);

        System.out.println("登陆成功，欢迎您：" + username);
        request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
    }

    /**
     * 用户注册
     * @param request request请求
     * @param response response响应
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {//处理用户注册
        request.setCharacterEncoding("utf-8");

        //获取请求的参数 【参数多了就比较麻烦，可以用工具包BeanUtils来处理】
        //包commons-beanutils-1.8.0.jar 和 commons-logging-1.1.1.jar
        /*
                User user = new User();
                try {
                    //借助工具类将 前端传递的参数注入到对应对象User中  后面取的话直接 User.getName()即可
                    BeanUtils.populate(user,request.getParameterMap());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                //使用自己定义的封装方法
                WebUtils.copyParamsToBean(request,request.getParameterMap());
         */
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        //检查验证码是否正确
        HttpSession session = request.getSession();
        String verityCode = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (!(verityCode != null && verityCode.equalsIgnoreCase(code))) {
            System.out.println("验证吗错误！" + code);
            request.setAttribute("msg","验证码错误！");
            //返回用户填写的数据
            setReqAttribute(request,username,password,email,code);
            //如果不正确，跳回注册页面
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/user/regist.jsp");
            //千万不要忘记forward
            requestDispatcher.forward(request,response);
            return;
        }

        // 查询用户是否存在
        if (userService.existUserName(username)) {
            request.setAttribute("msg","该用户名已存在！！");
            //返回用户填写的数据
            setReqAttribute(request,username,password,email,code);
            //存在相同用户名
            System.out.println("该用户名已存在！ " + username);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            return;
        }

        //插入数据库失败
        if (!userService.registerUser(new User(null,username,password,email))) {
            request.setAttribute("msg","注册失败，请联系管理员!");
            //返回用户填写的数据
            setReqAttribute(request,username,password,email,code);
            System.out.println("插入数据失败!");
            request.getRequestDispatcher("pages/user/regist.jsp").forward(request,response);
            return;
        }

        System.out.println("注册成功，！");
        request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);

    }

    /**
     * 用来处理表单回显
     * @param request request请求
     * @param username 用户名
     * @param password 密码
     * @param email 电子邮箱
     * @param code 验证码
     */
    public void setReqAttribute(HttpServletRequest request,String username,String password, String email,String code) {
        request.setAttribute("username",username);
        request.setAttribute("password",password);
        request.setAttribute("email",email);
        request.setAttribute("code",code);
    }


    /**
     * 用户注销 [销毁session或者销毁session的值]
     * @param request request请求
     * @param response response响应
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
        }
        response.sendRedirect(request.getContextPath());//自己会重定向
    }

    /**
     * ajax请求判断当前用户名是否已经存在
     * @param request 请求
     * @param response 响应
     * @throws IOException 异常
     * @throws ServletException 异常
     */
    public void verifyUsername(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        boolean isAvailable = true;
        String username = request.getParameter("username");
        if (username != null) {
            boolean ret = userService.existUserName(username);
            if (ret) {
                isAvailable = false;
            }
        }
        //将结果放入json中并传递给客户端  或者写个list或map都行转成json发送给浏览器
        JsonObject obj = new JsonObject();
        obj.addProperty("isAvailable",isAvailable);
        response.getWriter().write(new Gson().toJson(obj));
    }
}
