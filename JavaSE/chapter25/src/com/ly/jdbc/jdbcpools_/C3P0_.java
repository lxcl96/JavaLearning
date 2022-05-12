package com.ly.jdbc.jdbcpools_;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author : Ly
 * @Date : 2022/4/19
 * @Description : 演示C3P0的使用
 */
public class C3P0_ {
    //方式1:相关参数在程序中指定 user url password等

    @Test
    public void testC3P0_01() throws Exception {
        //1、创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2、通过配置文件 获取相关信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/ly/jdbc/jdbc.properties"));

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        //给数据源设置相关的参数 【将连接的权限给数据源，Java程序每次使用连接都去数据源那儿排队获取】
        comboPooledDataSource.setDriverClass(driver);//设置驱动
        comboPooledDataSource.setJdbcUrl(url);//设置连接
        comboPooledDataSource.setUser(user);//设置用户
        comboPooledDataSource.setPassword(password);//设置密码


        comboPooledDataSource.setInitialPoolSize(10);//设置初始化链接数
        comboPooledDataSource.setMaxPoolSize(50);//最大连接数

        //获取一个连接
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("连接成功");
        connection.close();//不是把数据库连接池的连接关闭，而是把Java程序申请的连接池的连接关闭


    }

    //C3P0_02 使用配置文件 C3P0-config.xml 得到数据库连接池
    //将配置文件 C3P0-config.xml 放到src目录下
    @Test
    public void C3P0_02() throws SQLException {
        //C3P0-config.xml 文件中配置的连接名
        ComboPooledDataSource mysql_test = new ComboPooledDataSource("mysql_test");

        mysql_test.getConnection();
        System.out.println("ok");
        mysql_test.close();
    }
}
