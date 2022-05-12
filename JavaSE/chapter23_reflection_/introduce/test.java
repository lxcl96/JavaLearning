package chapter23_reflection_.introduce;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author : Ly
 * @Date : 2022/4/14
 * @Description : 使用现有方法尝试解决需求
 */
public class test {
    @SuppressWarnings({"all"})
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter23_reflection_\\introduce\\re.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(filePath));
        String classfullpath = properties.getProperty("classfullpath");
        String method = properties.getProperty("method");

        //字符串类型 不是类
        //new classfullpath().hi();

        //反射机制解决 快速入门
        //(1)加载类,加载指定路径类对象
        Class<?> aClass = Class.forName(classfullpath);

       //(2)通过 aClass 得到你加载的类 chapter23_reflection_.introduce.Cat 的对象实例
        Object o = aClass.newInstance();//运行类型就是chapter23_reflection_.introduce.Cat

        //(3)通过aClass.getMehod() 得到你加载得类 chapter23_reflection_.introduce.Cat 的 指定方法 method 的方法对象
        //      即：在反射中，可以把方法视为对象（万物皆对象的概念）
        Method method1 = aClass.getMethod(method);

        //(4)通过 method1调用方法：即通过方法对象来实现调用方法
        method1.invoke(o);  //反过来 方法对象.invoke(类对象)

        //Class

    }
}
