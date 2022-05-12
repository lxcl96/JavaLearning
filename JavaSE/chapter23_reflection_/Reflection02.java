package chapter23_reflection_;

import chapter23_reflection_.introduce.Cat;

import java.lang.reflect.Method;

/**
 * @Author : Ly
 * @Date : 2022/4/14
 * @Description : 测试反射机制的性能和优化
 */
public class Reflection02 {
    public static void main(String[] args) throws Exception{
        m1(); //耗时 5
        m2(); //开启访问检查耗时257、关闭访问检查耗时209
    }

    //传统方法调用hi  耗时378409
    public static void m1() {
        Cat cat = new Cat();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            cat.hi();
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);

    }

    //反射机制调用hi
    public static void m2() throws Exception{
        Class<?> aClass = Class.forName("chapter23_reflection_.introduce.Cat");
        Object o = aClass.newInstance();
        Method hi = aClass.getMethod("hi");
        hi.setAccessible(true);//调用方法取消访问检查
        long l = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            hi.invoke(o);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);

    }
}
