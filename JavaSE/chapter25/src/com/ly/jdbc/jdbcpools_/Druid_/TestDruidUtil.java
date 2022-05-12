package com.ly.jdbc.jdbcpools_.Druid_;

import com.ly.jdbc.utils.JDBCUtilsByDruid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author : Ly
 * @Date : 2022/4/19
 * @Description : 测试刚写的Druid工具
 */
public class TestDruidUtil {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from casetest";
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection.getClass());
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        //这个结果集 使用不方便于是就有人想出来重新建一个工具类，定义一些字段就是数据库的字段如name score course等
        // ===》这种类就被人叫做JavaBean 或POJO或Domain
        //即 ArrayList<casetest>
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String course = resultSet.getString("course");
            String score = resultSet.getString("score");
            System.out.println(String.format("%s  %s  %s  %s",id,name,course,score));
        }
        JDBCUtilsByDruid.close(resultSet,preparedStatement,connection);
    }
}
