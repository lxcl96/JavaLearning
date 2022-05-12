package com.ly.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author : Ly
 * @Date : 2022/4/18
 * @Description : 这是一个工具类，用于mysql的连接和关闭
 */

@Deprecated
public class JdbcUtils {
    //定义相关的属性  [因为只需要一份，做成静态的]
    static String url;
    static String user;
    static String pwd;
    static String driver;

    //在Static代码块进行初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\com\\ly\\jdbc\\jdbc.properties"));
            user = properties.getProperty("user");
            pwd = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");


        } catch (IOException e) {
            //实际开发中，我们会将其变成运行异常 抛出
            //1、将编译异常变成运行异常，这是调用者可以将异常捕获 或者输出
            throw new RuntimeException(e);
        }

    }

    //连接数据库返回一个Connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            //实际开发中，我们会将其变成运行异常 抛出
            //1、将编译异常变成运行异常，这是调用者可以将异常捕获 或者输出
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet set, Statement statement,Connection connection) {
        //如果需要关闭就传入实参，否则传入空值
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
