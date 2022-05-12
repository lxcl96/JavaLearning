package com.ly.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author : Ly
 * @Date : 2022/4/17
 * @Description :JDBC程序完成简单的sql操作【静态加载】
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //1、注册驱动
        Driver driver = new Driver();
        //2、得到链接
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        Properties properties = new Properties();
        //user password是规定好的key
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        Connection connect = driver.connect(url, properties);

        //3、执行sql语句
        String sql = "insert into actor values(null,\"刘德华\",'男','1970-11-11','110')";
        //用于执行静态sql语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int i = statement.executeUpdate(sql);//返回影响的行数 返回0失败
        System.out.println(i > 0 ? "成功":"失败");

        statement.close();
        connect.close();

    }
}
