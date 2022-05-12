//package com.ly.web; /**
// * @Author : Ly
// * @Date : 2022/4/26
// * @Description :
// */
//
//import com.ly.bean.User;
//import com.ly.service.UserService;
//import com.ly.service.impl.UserServiceImpl;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import java.io.IOException;
//
//public class registerServlet extends HttpServlet {
//    //web层不能直接调用dao层，只能调用service层
//    private UserService userService= new UserServiceImpl();
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //处理用户注册
//        request.setCharacterEncoding("utf-8");
//
//        //获取请求的参数
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");
//        String code = request.getParameter("code");
//
//        //检查验证码是否正确 [要求验证码为 abcde] 比较时忽略大小写
//        if (!"abcde".equalsIgnoreCase(code)) {
//            System.out.println("验证吗错误！" + code);
//            request.setAttribute("msg","验证码错误！");
//            //返回用户填写的数据
//            setReqAttribute(request,username,password,email,code);
//            //如果不正确，跳回注册页面
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/user/regist.jsp");
//            //千万不要忘记forward
//            requestDispatcher.forward(request,response);
//            return;
//        }
//
//        // 查询用户是否存在
//        if (userService.existUserName(username)) {
//            request.setAttribute("msg","该用户名已存在！！");
//            //返回用户填写的数据
//            setReqAttribute(request,username,password,email,code);
//            //存在相同用户名
//            System.out.println("该用户名已存在！ " + username);
//            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
//            return;
//        }
//
//        //插入数据库失败
//        if (!userService.registerUser(new User(null,username,password,email))) {
//            request.setAttribute("msg","注册失败，请联系管理员!");
//            //返回用户填写的数据
//            setReqAttribute(request,username,password,email,code);
//            System.out.println("插入数据失败!");
//            request.getRequestDispatcher("pages/user/regist.jsp").forward(request,response);
//            return;
//        }
//
//        System.out.println("注册成功，！");
//        request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
//
//    }
//
//    public void setReqAttribute(HttpServletRequest request,String username,String password, String email,String code) {
//        request.setAttribute("username",username);
//        request.setAttribute("password",password);
//        request.setAttribute("email",email);
//        request.setAttribute("code",code);
//    }
//}
