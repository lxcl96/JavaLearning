package com.ly.dao;

import com.ly.bean.User;

/**
 * @Author : Ly
 * @Date : 2022/4/26
 * @Description : 每个表有对应的DAO接口，用来规范方法
 */
public interface UserDao {


    /**
     * 验证用户名是否有效
     * @param username 用户名
     * @return 返回查询结果，如果为 null表示没有查到
     */
    public User queryByUsername(String username);

    /**
     * 保存注册的用户
     * @param user 注册的用户bean
     * @return 插入数据库返回影响的行数
     */
    public int saveUser(User user);

    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 返回null说明不存在该用户
     */
    public User queryByUsernameAndPassword(String username,String password);
}
