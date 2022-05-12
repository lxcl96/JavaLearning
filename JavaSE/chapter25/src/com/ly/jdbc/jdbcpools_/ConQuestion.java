package com.ly.jdbc.jdbcpools_;

import com.ly.jdbc.utils.JdbcUtils;

import java.sql.Connection;

/**
 * @Author : Ly
 * @Date : 2022/4/19
 * @Description :  传统方法的问题，1：连接数太多连接不上 2：频繁的连接关闭太费时
 */
public class ConQuestion {
    public static void main(String[] args) {
        //代码 连接mysql 5000次
        for (int i = 0; i < 5000; i++) {
            //使用传统的方法得到连接
            Connection connection = JdbcUtils.getConnection();
            //做一些工作，比如PreparedStatement 发送sql
            //... 故意不关闭 就会连接不上

        }
    }
}
