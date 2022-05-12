//package com.ly.web; /**
// * @Author : Ly
// * @Date : 2022/4/27
// * @Description :
// */
//
//import com.ly.bean.User;
//import com.ly.service.impl.UserServiceImpl;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import java.io.IOException;
//
//public class loginServlet extends HttpServlet {
//    //和数据库打交道的就是DAO层，但是web层不能直接访问dao层，只能访问service层
//    private UserServiceImpl userService = new UserServiceImpl();
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //用户登陆校验
//        request.setCharacterEncoding("utf-8");
//        //获取参数
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        //访问数据库 看看用户是否存在 如果存在再进行密码校验
//        if (!userService.existUserName(username)) {
//            System.out.println("该用户名不存在！" + username);
//            request.setAttribute("msg","该用户名不存在！");
//            request.setAttribute("username",username);
//            request.setAttribute("password",password);
//            //返回登陆界面 ,如果直接返回login的servlet程序会导致死循环，因为参数没有发送变化总是不合法的
//            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
//            return;
//        }
//
//        //如果用户名存在进行账号密码校验
//        if (userService.login(new User(null,username,password,null)) == null) {
//            System.out.println("登录密码错误，请检查！");
//            request.setAttribute("msg","登录密码错误，请检查！");
//            request.setAttribute("username",username);
//            request.setAttribute("password",password);
//            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
//            return;
//        }
//
//        System.out.println("登陆成功，欢迎您：" + username);
//        request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
//    }
//}
