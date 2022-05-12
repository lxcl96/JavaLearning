package chapter23_reflection_;

import org.junit.Ignore;
import org.junit.Test;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author : Ly
 * @Date : 2022/4/15
 * @Description : 演示如何通过反射获取类结构信息
 */
public class ReflectionUtils {
    public static void main(String[] args) {

    }

    @Test
    //第一组方法API
    public void api_01() throws ClassNotFoundException {
        Class<?> personCls = Class.forName("chapter23_reflection_.Person");
        //获取全类名
        System.out.println(personCls.getName());
        //获取简单类名
        System.out.println(personCls.getSimpleName());
        System.out.println("===================");
        //获取所有public修饰的字段 包括本类和父类
        Field[] fields = personCls.getFields();
        for (Field f:fields) {
            System.out.println(f.getName());
        }

        //getDeclaredFields() 获取所有属性 只有本类
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("++" + declaredField);
        }

        //获取所有public方法  包括本类和父类的
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("---" + method);
        }

        //getDeclaredMethods() 获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("////" + declaredMethod);
        }

        //获取public类型的构造器  只包括本类
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor + "====");
        }

        //获取本类所有的构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("===" + declaredConstructor);
        }

        //获取包信息
        System.out.println(personCls.getPackage());

        //以Class形式返回父类信息
        System.out.println(personCls.getSuperclass());

        //以Class[] 形式返回接口数组
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("interface ++  " + anInterface);
        }

        //以Annotation[]返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("*****" + annotation);
        }

    }

    @Test
    //第二组方法API
    public void api_02() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("chapter23_reflection_.Person");

        //获取所有属性的修饰符
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field + "属性修饰符是" + field.getModifiers() + "  该属性的类型" + field.getType());
        }
    }
}

@Deprecated
class Person extends A implements Comparable{
    public static String name;
    protected  int age;
    String job;
    private double sal;

    public Person(String name) {
        super(name);
        this.name = name;
    }

    private Person(int age) {
        super(age);
        this.age = age;
    }

    protected Person(String name, int age, String job) {
        super(name);
        this.name = name;
        this.age = age;
        this.job = job;
    }

    private Person(double sal) {
        super(1);
        this.sal = sal;
    }

    public void m1(){}
    protected void m2(){}
    void m3(){}
    private void m4(){}

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

@Ignore
class A implements Serializable {
    public String hobby;
    protected  int aa;
    String bb;
    private double cc;


    public void f1(){}
    protected void f2(){}
    void f3(){}
    private void f4(){}

    public A(String hobby) {
        this.hobby = hobby;
    }

    protected A(int aa) {
        this.aa = aa;
    }

    A(String hobby, int aa, String bb) {
        this.hobby = hobby;
        this.aa = aa;
        this.bb = bb;
    }

    private A(double cc) {
        this.cc = cc;
    }
}