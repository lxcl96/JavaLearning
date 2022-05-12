package com.ly.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author : Ly
 * @Date : 2022/4/18
 * @Description :
 */
public class HomeWork01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/ly/jdbc/jdbc.properties"));

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        Class<?> aClass = Class.forName(driver);
        Connection c1 = DriverManager.getConnection(url, user, password);
        Statement statement = c1.createStatement();
        //int res = statement.executeUpdate("create table news(id int primary key auto_increment,content varchar(500))");
        ResultSet resultSet = statement.executeQuery("select * from news");
        while (resultSet.next()) {
            int anInt = resultSet.getInt(1);
            String string = resultSet.getString(2);
            System.out.println(anInt + " " + string);
        }
        //dml（增删改）语句返回0代表失败
        //ddl（建表，alter，drop表）语句就是返回0
//        if (res == 0) {
//            System.out.println("建表失败，请检查！");
//        }

//        statement.executeUpdate("update news set content = '这个是第一条语句的加强版' where news.id=1");
//        statement.executeUpdate("delete from news where news.id=3");
//        statement.executeUpdate("insert into news(content) value ('这是第3个新闻')");
//        statement.executeUpdate("insert into news(content) value ('这是第4个新闻')");
//        statement.executeUpdate("insert into news(content) value ('这是第5个新闻')");


        resultSet.close();
        statement.close();
        c1.close();
    }
}
