package com.ly.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author : Ly
 * @Date : 2022/4/18
 * @Description : 分析连接mysql的五种方式
 */
public class JdbcConn {

    @Test
    public void conn01() throws SQLException {
        //方式1 静态加载
        Driver driver = new Driver();
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");

        Connection connect = driver.connect("jdbc:mysql://127.0.0.1:3306/test",properties);
        System.out.println(connect);
        connect.close();
    }

    @Test
    public void conn02() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //使用Class对象，动态加载 更加灵活，减少依赖性
        Class<?> driverCls = Class.forName("com.mysql.jdbc.Driver");
        Object dirver = driverCls.newInstance();
        //可以直接在这里进行强转 成Driver类型，下面方便了 正常写

        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");

        Method connect = driverCls.getMethod("connect", String.class, Properties.class);
        Object invoke = connect.invoke(dirver,"jdbc:mysql://127.0.0.1:3306/test",properties);

        System.out.println(invoke + "运行类型" + invoke.getClass());


        ((Connection)invoke).close();
    }

    @Test
    public void conn03() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //方式3 使用DriverManager 替代Driver进行统一管理 更好扩展（不用创建properties对象）
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");

        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();

        DriverManager.registerDriver(driver);//注册Driver驱动
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", properties);

        System.out.println(connection);
        connection.close();
    }

    @Test
    public void conn04() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //方式4  Class.forName自动注册驱动属于3的升级版
        //在加载Driver类时，自动完成注册
        /*
            Mysql驱动包5.1.6之后也可以不用写 Class.forName("com.mysql.jdbc.Driver");了，因为是
            自动调用驱动jar包下META-INF\services\java.sql.Driver文本中的类名去注册
         */
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");//可以去掉

        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123456");
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void conn05() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
        //方式5  对方式5进行优化即讲mysql三件套写成配置信息
        Properties properties = new Properties();
        //properties.load(new FileInputStream("D:\\JavaWork\\chapter25\\src\\com\\ly\\jdbc/jdbc.properties"));
        properties.load(new FileInputStream("src\\com\\ly\\jdbc/jdbc.properties"));
        Class<?> aClass = Class.forName(properties.getProperty("driver"));//可以去掉

        Connection connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("user"), properties.getProperty("password"));
        System.out.println(connection);
        connection.close();
    }
}
