package chapter23_reflection_;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author : Ly
 * @Date : 2022/4/15
 * @Description : 演示通过反射机制创建实例
 */
public class ReflectCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //1、获取到User的Class对象
        Class<?> userCls = Class.forName("chapter23_reflection_.User");

        //2、通过public的无参构造器创建实例  这三步可以简化为  Object o = userCls.newInstance();
        Constructor<?> constructor = userCls.getConstructor();
        Object o = constructor.newInstance();
        System.out.println(o);

        //3、通过public的有参构造器创建实例
        Constructor<?> constructor1 = userCls.getConstructor(String.class);
        Object o1 = constructor1.newInstance("哈哈");
        System.out.println(o1);

        //4、通过非public的有参构造器创建对象 通过指定参数类型获取指定构造器【】
        Constructor<?> declaredConstructor = userCls.getDeclaredConstructor(int.class, String.class);
        declaredConstructor.setAccessible(true);//去掉隐私权限
        Object ht = declaredConstructor.newInstance(5, "核桃");
        System.out.println(ht);
    }
}

class User {
    private int age = 10;
    private String name = "mimi";

    public User() {}

    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void hi() {
        System.out.println("hi");
    }
    private int haha(String name) {
        System.out.println("hah" + name);
        return 122;
    }
    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}