package chapter23_reflection_;

import java.lang.reflect.Field;

/**
 * @Author : Ly
 * @Date : 2022/4/15
 * @Description : 演示如何通过反射机制访问非public属性
 */
public class ReflectAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //1、获取到User的Class对象
        Class<?> userCls = Class.forName("chapter23_reflection_.User");
        Object o = userCls.newInstance();
        //获取所有属性 所有
        Field age = userCls.getDeclaredField("age");
        age.setAccessible(true); //暴力破解访问权限设置
        //非静态属性需要指定一个该类的实例对象，如果是静态属性 可直接写成null
        System.out.println(age.get(o));
        age.setInt(o,11);
        System.out.println(age.get(o));

        Field name = userCls.getDeclaredField("name");
        name.setAccessible(true); //暴力破解访问权限设置
        //非静态属性需要指定一个该类的实例对象，如果是静态属性 可直接写成null
        System.out.println(name.get(o));
        name.set(o,"哈哈");
        System.out.println(name.get(o));
    }
}
