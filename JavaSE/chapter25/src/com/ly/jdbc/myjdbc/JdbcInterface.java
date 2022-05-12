package com.ly.jdbc.myjdbc;

/**
 * @Author : Ly
 * @Date : 2022/4/17
 * @Description : 模拟规定JDBC接口，由Java厂商规定接口
 */
public interface JdbcInterface {

    //连接
    public Object getConnection();

    //crud
    public void crud();

    //关闭连接
    public void close();

}
