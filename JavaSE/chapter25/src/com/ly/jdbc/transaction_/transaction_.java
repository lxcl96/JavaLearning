package com.ly.jdbc.transaction_;

import com.ly.jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author : Ly
 * @Date : 2022/4/18
 * @Description : 模拟经典业务转账，不开启事务的情况
 */
public class transaction_ {
    public static void main(String[] args) throws SQLException {
        String sql = "update account set balance = balance - 100 where name = '马云'";
        String sql2 = "update account set balance = balance + 100 where name = '马化腾'";
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();

        //异常业务导致程序崩溃，代码执行中断，导致帐目金额流水不对，
        // 此时数据库没有开启事务操作，导致无法回滚，自动提交了
        int i = 1 / 0;
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
        preparedStatement1.executeUpdate();
        preparedStatement1.close();
        JdbcUtils.close(null,preparedStatement,connection);


    }
}
