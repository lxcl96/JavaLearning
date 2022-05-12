package com.ly.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Stack;

/**
 * @Author : Ly
 * @Date : 2022/4/26
 * @Description : 处理数据连接
 */
public class JdbcUtils {
    private static DataSource dataSource;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        Properties properties = new Properties();
        try {
            //反射方式获取
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //properties.load(new FileInputStream("src/jdbc.properties"));
            properties.load(inputStream);

            //加载Druid
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据库连接池中的连接
     * @return 数据库连接
     */
    public static Connection getConnection() {
        //同一个线程第一次获取连接 是新的，但是第二次的话就是旧的
        Connection connection = threadLocal.get();
        try {
            if (connection == null) {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
                //开启事务
                connection.setAutoCommit(false);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    /**
     * 关闭数据库连接池中的连，放回到数据库连接池
     */
    public static void close(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 开启事务后，提交和关闭连接
     */
    public static void commitAndClose() {
        Connection connection = threadLocal.get();

        //如果不为空，说明使用过连接 则需要提交事务和关闭连接
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        threadLocal.remove();//用完必须要将其从threadLocal中移除
    }

    /**
     * 开启事务后，回滚和关闭连接
     */
    public static void rollBackAndClose() {
        Connection connection = threadLocal.get();

        //如果不为空，说明使用过连接 则需要提交事务和关闭连接
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        threadLocal.remove();//用完必须要将其从threadLocal中移除
    }



}
