package com.ly.jdbc.batch_;

import com.ly.jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author : Ly
 * @Date : 2022/4/18
 * @Description : 演示Java批处理
 */
public class Batch_ {
    public static void main(String[] args) throws SQLException {
        String sql = "insert into account values(null,?,?)";

        //注意 需要开启批量处理在url中添加  ?rewriteBatchedStatement=true
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1,"tom" + i);
            preparedStatement.setDouble(2,100);
            preparedStatement.addBatch(); //放到arraylist数组里

            //每1000条执行一下
            if ((i + 1) % 1000 == 0) {
                preparedStatement.executeBatch();
                //然后清空batch
                preparedStatement.clearBatch();
            }
        }
        System.out.println("批量添加完成");
        JdbcUtils.close(null,preparedStatement,connection);

    }
}
