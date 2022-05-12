package com.ly.jdbc.jdbcpools_.Druid_;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author : Ly
 * @Date : 2022/4/19
 * @Description :
 */
public class Druid_ {

    @Test
    public void testDruid() throws Exception {
        //1、引入Druid jar包
        //2、加入Druid配置文件Druid.properties到src目录下
        //3、创建properties对象 读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src//druid.properties"));

        //4、创建Druid连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println("连接成功");
        connection.close();
    }
}
