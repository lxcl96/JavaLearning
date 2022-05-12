package com.ly.jdbc.DBUtils_;

import com.ly.jdbc.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Ly
 * @Date : 2022/4/19
 * @Description : 展示DBUtils的用法
 */
public class DBUtils_Use {
    //使用apache-DBUtils 工具类 + Druid 完成对表的crud操作

    @Test
    public void testQueryMany() throws SQLException {
        //返回结果是多行的情况


        //String sql = "\"select * from casetest where name =?\"";
        String sql = "select course,score from casetest where name =?";
        //1、得到一个连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2、使用DBUtils 类和接口 引入jar文件 commons-dbutils-1.3.jar
        //  创建一个QueryRunner类，
        QueryRunner queryRunner = new QueryRunner();
        //3、就可以执行查询了，返回一个结果集 queryRunner.query()得到一个ResultSet封装到一个ArrayList集合中
        List<CaseTest> query =
                //1、连接
                //2、sql
                //3、【将结果集中的每一行数据封装到一个对应的JavaBean实例中，存放到List里】 即resultSet-->CaseTest对象-->封装到ArrayList 和我们的土方法一样
                //传入表的Class对象就是为了利用反射机制，查看有哪些对象，将其封装到ArrayList集合中
                //4、sql参数参数 表示传递给sql中的问号的,有多个问号就可以传递多个
                queryRunner.query(connection, sql, new BeanListHandler<>(CaseTest.class), "二狗");

        //上面的方法会自动关闭底层的ResultSet和Statement 而且人家也没返回这个啊  所以只需要关闭connect
        JDBCUtilsByDruid.close(null, null, connection);


        for (CaseTest a : query) {
            System.out.println(a);
        }
    }
        @Test
        public void testQuerySingle () throws SQLException {
            //返回结果是单行多列的情况  单行单列的可以把BeanHandler 换成new ScalarHandler()


            //String sql = "\"select * from casetest where name =?\"";
            String sql = "select course,score from casetest where name =? and course=?";
            //1、得到一个连接
            Connection connection = JDBCUtilsByDruid.getConnection();
            //2、使用DBUtils 类和接口 引入jar文件 commons-dbutils-1.3.jar
            //  创建一个QueryRunner类，
            QueryRunner queryRunner = new QueryRunner();
            //3、就可以执行查询了，返回一个单行记录 queryRunner.query()得到一个CaseTest对象即Bean集合
            CaseTest query =
                    //1、连接
                    //2、sql
                    //3、返回JavaBean实例
                    //4-5、sql参数参数 表示传递给sql中的问号的,有多个问号就可以传递多个
                    queryRunner.query(connection, sql, new BeanHandler<>(CaseTest.class), "二狗", "math");

            //上面的方法会自动关闭底层的ResultSet和Statement 而且人家也没返回这个啊  所以只需要关闭connect
            JDBCUtilsByDruid.close(null, null, connection);

            System.out.println(query.getScore());

        }


    @Test
    public void testQueryManyColumns () throws SQLException {
        //返回结果是多行单列的情况


        //String sql = "\"select * from casetest where name =?\"";
        String sql = "select score from casetest";
        //1、得到一个连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2、使用DBUtils 类和接口 引入jar文件 commons-dbutils-1.3.jar
        //  创建一个QueryRunner类，
        QueryRunner queryRunner = new QueryRunner();
        //3、就可以执行查询了，返回一个多行单列记录 queryRunner.query()得到一个CaseTest对象
        List<Object> query = queryRunner.query(connection, sql, new ColumnListHandler());

        //上面的方法会自动关闭底层的ResultSet和Statement 而且人家也没返回这个啊  所以只需要关闭connect
        JDBCUtilsByDruid.close(null, null, connection);

        for (Object a : query) {
            System.out.println(a);
        }

    }

    @Test
    public void insert () throws SQLException {
        //dml语句


        //String sql = "\"select * from casetest where name =?\"";
        String sql = "insert into casetest value (null ,?,'math',?)";
        //1、得到一个连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2、使用DBUtils 类和接口 引入jar文件 commons-dbutils-1.3.jar
        //  创建一个QueryRunner类，
        QueryRunner queryRunner = new QueryRunner();
        //3、update方法 增删改都可以 返回受影响的行数
        int update = queryRunner.update(connection, sql,"大黄",0);
        //上面的方法会自动关闭底层的ResultSet和Statement 而且人家也没返回这个啊  所以只需要关闭connect
        JDBCUtilsByDruid.close(null, null, connection);

    }

}
