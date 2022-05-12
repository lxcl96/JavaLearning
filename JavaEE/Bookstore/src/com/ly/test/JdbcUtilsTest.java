package com.ly.test;

import com.ly.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author : Ly
 * @Date : 2022/4/26
 * @Description :
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() {
        Connection conn = JdbcUtils.getConnection();
        System.out.println(conn);
        JdbcUtils.close(conn);
    }
}
