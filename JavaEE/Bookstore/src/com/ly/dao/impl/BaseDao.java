package com.ly.dao.impl;

import com.ly.bean.User;
import com.ly.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import sun.management.jdp.JdpController;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author : Ly
 * @Date : 2022/4/26
 * @Description : 基类/抽象类，其他类继承 此类
 */
public abstract class BaseDao<T> {
    //使用DBUtils操作数据库
    private  QueryRunner queryRunner = new QueryRunner();


    /**
     * update方法用来进行dml操作
     * @param sql sql语句
     * @param params sql参数
     * @return 影响的行数
     */
    public  int update( String sql, Object... params) {
        //System.out.println("****当前订单线程名为：" + Thread.currentThread().getName());
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询单个Bean结果
     * @param sql sql语句
     * @param cls 要返回查询结果的类型，一般为bean对象对应的Class【每个表对应的bean】
     * @param params sql参数
     * @return 要返回查询结果的类型
     */
    public T selectSingle(String sql,Class<T> cls,Object... params) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(cls), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回多个JavaBean的方法
     * @param sql sql语句
     * @param cls 要返回类型
     * @param params sql参数
     * @return
     */
    public  List<T>  selectMany(String sql,Class<T> cls,Object... params) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(cls),params);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 查询返回单列值
     * @param sql sql语句
     * @param params sql参数
     * @return 查询单列结果
     */
    public Object selectScalar(String sql,Object... params) {
        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),params);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

}
