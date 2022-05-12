package chapter23_reflection_;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author : Ly
 * @Date : 2022/4/14
 * @Description :
 */
public class reflection01 {

    @SuppressWarnings({"all"})
    public static void main(String[] args) throws Exception{
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter23_reflection_\\introduce\\re.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(filePath));
        String className = properties.getProperty("classfullpath");
        String method = properties.getProperty("method");

        //使用反射
        //1、通过类名获取该类对应的 Class类
        Class<?> aClass = Class.forName(className);
        //2、通过获取到该类对应的Class类，创建一个该类的新实例【新对象】
        Object o = aClass.newInstance();

        //3、如果要获取该类的字段 就需要根据字段名name来获取 字段name对象 [注意：只能读取到public类型的字段]
        Field nationField = aClass.getField("nation");//name,age,color都不行
        //3.1输出获取的字段  反过来写 字段对象.get(该类的新实例，新对象)  正常：对象.字段
        //              【如果写的时该类的class类，会提示没有初始化 因为该类的Class类只保存了结构没有数据】
        System.out.println(nationField.get(o));

        //4、如果想要获取该类的方法 [注意：只能读取到public类型的字段]
        Method hiMethod = aClass.getMethod("hi");
        //4.1使用该方法 该方法对象的实例.invoke(该类的新实例)
        hiMethod.invoke(o);

        //5、构造器,直接就调用了 [注意：只能读取到public类型的字段] 细节：先运行了 构造器
        Constructor<?> constructor = aClass.getConstructor();//无参构造器 ，加什么参数对于什么构造器,
        System.out.println(constructor);

        Constructor<?> constructor1 = aClass.getConstructor(String.class);//传入形参的class对象
        System.out.println(constructor1);

    }
}
