package com.ly.jdbc.BasicDao_.dao_.dao;

import com.ly.jdbc.BasicDao_.dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author : Ly
 * @Date : 2022/4/19
 * @Description : 所有DAO类的父类，里面具有公共的方法 如dml操作
 */
//加泛型的 原因是为了方便传递子类型
public class BasicDAO<T> {
    private QueryRunner queryRunner = new QueryRunner();


    /**
     *
     * @param sql 执行的sql
     * @param params 参数数组
     * @return 受影响的行数
     */
    public int update(String sql,Object... params) {
        //开发通用的dml操作，针对所有表
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnect();
            //使用apache工具类来操作
            int num = queryRunner.update(connection, sql, params);
            return num; //写在这里就OK了
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }


    /**
     *
     * @param sql 执行的sql
     * @param cls  需要返回的Class对象 例如：report 表对应的 Report对象
     * @param params 参数数组
     * @return 查询到多行数据集合
     */
    public List<T> queryMany(String sql,Class<T> cls, Object... params) {
        //返回多个对象【即多行】针对任意一个表
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnect();
            //使用apache工具类来操作
            return queryRunner.query(connection, sql, new BeanListHandler<T>(cls), params); //直接返回更简洁

        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    /**
     *
     * @param sql 执行的sql
     * @param cls  需要返回的Class对象 例如：report 表对应的 Report对象
     * @param params 参数数组
     * @return 查询到单行对象
     */
    public T querySingle(String sql, Class<T> cls, Object... params) {
        //查询单行的通用方法
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnect();
            //使用apache工具类来操作
            return queryRunner.query(connection, sql, new BeanHandler<T>(cls), params); //直接返回更简洁

        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    /**
     *
     * @param sql 执行的sql
     * @param params 参数数组
     * @return 查询到单行单列 即单值
     */
    public Object queryScalar(String sql, Object... params) {
        //单行单列的方法 即返回单值的方法
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnect();
            //使用apache工具类来操作
            return queryRunner.query(connection, sql,new ScalarHandler(), params); //直接返回更简洁

        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
}
