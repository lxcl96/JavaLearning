package com.ly.jdbc.transaction_;

import com.ly.jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author : Ly
 * @Date : 2022/4/18
 * @Description :
 */
public class transaction01_ {
    public static void main(String[] args) {
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        Connection connection = null;
        try{
            String sql = "update account set balance = balance - 100 where name = '马云'";
            String sql2 = "update account set balance = balance + 100 where name = '马化腾'";
            connection = JdbcUtils.getConnection();
            //开启事务 即关闭自动提交
            connection.setAutoCommit(false);
            connection.setSavepoint("begin");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            //异常业务导致程序崩溃，代码执行中断，导致帐目金额流水不对，
            // 此时数据库没有开启事务操作，导致无法回滚，自动提交了
            int i = 1 / 0;
            preparedStatement1 = connection.prepareStatement(sql2);
            preparedStatement1.executeUpdate();

            //没意外最后提交事务
            connection.commit();
        } catch (SQLException e) {
            //出现异常可以回滚
            e.printStackTrace();
        } catch (ArithmeticException e){
            try {
                connection.rollback();
                System.out.println("回滚事务");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            try {
                if (preparedStatement1 != null)
                    preparedStatement1.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            JdbcUtils.close(null,preparedStatement,connection);
        }
    }
}
