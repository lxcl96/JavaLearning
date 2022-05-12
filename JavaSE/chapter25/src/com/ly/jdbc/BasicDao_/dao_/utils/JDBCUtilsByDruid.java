package com.ly.jdbc.BasicDao_.dao_.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author : Ly
 * @Date : 2022/4/19
 * @Description : 工具包用于数据连接获取（基于Druid的数据库连接池）
 */
public class JDBCUtilsByDruid {
    private static DataSource ds;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnect() {
        //从数据库连接池取出一个连接
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet re, Statement stmt, Connection c) {
        //关闭 结果集 Statement 和链接
        try {
            if (re != null)
                re.close();
            if (stmt != null)
                stmt.close();
            if (c != null)
                c.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
