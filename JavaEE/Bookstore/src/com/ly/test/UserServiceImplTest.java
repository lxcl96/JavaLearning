package com.ly.test;

import com.ly.bean.User;
import com.ly.dao.impl.UserDaoImpl;
import com.ly.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author : Ly
 * @Date : 2022/4/26
 * @Description :
 */
public class UserServiceImplTest {

    @Test
    public void login() {
        //测试其实现类
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(new User(null,"小猪", "123456", "123"));
        if (user != null) {
            System.out.println("登陆成功！" + user);
        } else {
            System.out.println("登陆失败！");
        }
    }

    @Test
    public void registerUser() {
        UserServiceImpl userService = new UserServiceImpl();
        boolean ret = userService.registerUser(new User(null,"king", "king", "king@ly.com"));
        if (ret) {
            System.out.println("注册成功！");
        } else {
            System.out.println("注册失败");
        }
    }

    @Test
    public void existUserName() {
        UserServiceImpl userService = new UserServiceImpl();
        if (userService.existUserName("king")) {
            System.out.println("用户存在");
        } else {
            System.out.println("用户不存在");
        }
    }
}