package com.ly.jdbc.preparestatement_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @Author : Ly
 * @Date : 2022/4/18
 * @Description : 演示 PreparedStatement 的使用
 */
public class PreparedStatement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入要插入的用户名");
//        String user = scanner.next();

//        System.out.println("请输入要插入的密码");
//        String pwd = scanner.next();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/ly/jdbc/jdbc.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user1 = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user1, password);
        //String sql1 = "create table admin(user varchar(20) primary key ,pwd varchar(128))";
        //String sql2 = "insert into admin value (?,?)";
        //String sql3 = "update admin set user =? where user = 'tom'";
        //String sql4 = "delete from admin where user = ?";
        PreparedStatement preparedStatement = connection.prepareStatement("select * from admin");
        //preparedStatement.setString(1,user);
        //int res = preparedStatement.executeUpdate();
        //System.out.println(res == 0 ? "创建失败":"创建成功");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + resultSet.getString(2));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();



    }
}
