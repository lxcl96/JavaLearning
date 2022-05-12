package com.ly.test;

import com.ly.bean.User;
import com.ly.dao.UserDao;
import com.ly.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author : Ly
 * @Date : 2022/4/26
 * @Description :
 */
public class UserDaoTest {

    @Test
    public void queryByUsername() {
        //测试其实现类
        UserDao userDao = new UserDaoImpl();
        //System.out.println(userDao.queryByUsername("admin"));
        if (userDao.queryByUsername("admin") != null) {
            System.out.println("用户名已存在");
        } else {
            System.out.println("用户名可用！");
        }
    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        int ret = userDao.saveUser(new User(null,"小猪", "123456", "xiaozhu@ly.com"));
        if (ret == 1) {
            System.out.println("保存成功！");
        }
    }

    @Test
    public void queryByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        if (userDao.queryByUsernameAndPassword("admin","admin") != null) {
            System.out.println("登陆成功");
        }
    }
}