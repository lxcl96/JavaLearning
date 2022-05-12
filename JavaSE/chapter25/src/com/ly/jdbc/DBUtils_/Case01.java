package com.ly.jdbc.DBUtils_;

import com.ly.jdbc.utils.JDBCUtilsByDruid;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Author : Ly
 * @Date : 2022/4/19
 * @Description : 引入DBUtils，例子：自己写DBUtils
 */
public class Case01 {
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

    @Test
    //使用土方法解决 ResultSet ==》 封装成ArrayList
    public void testSelectToArray() throws SQLException {
        ArrayList<CaseTest> casetest = new ArrayList<>();///创建ArrayList存放casetest（表）对象
        String sql = "select * from casetest";
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection.getClass());
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        //这个结果集 使用不方便于是就有人想出来重新建一个工具类，定义一些字段就是数据库的字段如name score course等
        // ===》这种类就被人叫做JavaBean 或POJO或Domain
        //即 ArrayList<casetest>
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String course = resultSet.getString("course");
            Double score = resultSet.getDouble("score");

            //把得到的 resultSet记录封装到 CaseTest对象中，放入到ArrayList对象中
            casetest.add(new CaseTest(id,name,course,score));
        }
        JDBCUtilsByDruid.close(resultSet,preparedStatement,connection);

        //关闭掉连接依然可以使用 结果
        for (int i = 0; i < casetest.size(); i++) {
            System.out.println(casetest.get(i));
        }
    }


}
