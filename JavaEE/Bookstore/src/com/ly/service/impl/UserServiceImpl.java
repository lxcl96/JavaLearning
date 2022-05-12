package com.ly.service.impl;

import com.ly.bean.User;
import com.ly.dao.UserDao;
import com.ly.dao.impl.UserDaoImpl;
import com.ly.service.UserService;

/**
 * @Author : Ly
 * @Date : 2022/4/26
 * @Description : UserService实现类
 */
public class UserServiceImpl implements UserService {
    //此处需要操纵，数据库，而和数据库打交道的就是DAO
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(User user) {
        //就是用用户名 和密码判断用户是否存在
        return userDao.queryByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean registerUser(User user) {
        if (existUserName(user.getUsername()))
            return false;
        int ret = userDao.saveUser(user);
        return ret == 1;
    }

    @Override
    public boolean existUserName(String username) {
        User user = userDao.queryByUsername(username);
        return user != null;
    }
}
