package com.ly.dao.impl;

import com.ly.bean.User;
import com.ly.dao.UserDao;

/**
 * @Author : Ly
 * @Date : 2022/4/26
 * @Description : 继承基类的，实现自身接口方法
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public User queryByUsername(String username) {
        String sql = "select * from t_user where username = ?";
        return selectSingle(sql, User.class, username);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user values (?,?,?,?)";
        return update(sql,null,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        return selectSingle(sql, User.class, username,password);
    }
}
