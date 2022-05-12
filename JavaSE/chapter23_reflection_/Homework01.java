package chapter23_reflection_;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author : Ly
 * @Date : 2022/4/15
 * @Description :
 * 1、定义PrivateTest类，有私有属性name，并且属性值为hellokitty
 * 2、提供getName的公有方法
 * 3、创建PrivateTest的类，利用Class类得到私有属性的属性，修改私有属性name的值，并调用getName反方打印出name的值
 */
public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<?> cls = Class.forName("chapter23_reflection_.PrivateTest");
        Class<PrivateTest> privateTestClass = PrivateTest.class;//也可以获得其Class
        Object o = cls.newInstance();
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        //爆破设置私有属性
        System.out.println(name.get(o) + " name的运行类型" + name.get(o).getClass().getSimpleName());
        name.set(o,"no，pig");
        Method getName = cls.getMethod("getName");
        Object invoke = getName.invoke(o);
        System.out.println(invoke + " name的运行类型" + invoke.getClass().getSimpleName());
    }
}


class PrivateTest {
    private String name = "helloKitty";

    public String getName() {
        return name;
    }
}