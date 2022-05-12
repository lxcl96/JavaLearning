package com.ly.service;

import com.ly.bean.User;

/**
 * @Author : Ly
 * @Date : 2022/4/26
 * @Description : 业务接口，对应用户
 */
public interface UserService {

    /**
     * 用户登陆
     * @param user 用户信息
     * @return 登陆的用户，返回null代表登陆失败
     */
    public User login(User user);

    /**
     * 注册用户
     * @param user 注册用户信息
     * @return 返回是否成功，true成功
     */
    public boolean registerUser(User user);

    /**
     * 根据用户名，判断用户是否存在
     * @param username 用户名
     * @return 返回是否存在该用户，true代表存在
     */
    public boolean existUserName(String username);
}
