package chapter23_reflection_.CLassLoad_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @Author : Ly
 * @Date : 2022/4/15
 * @Description : 演示静态加载
 */
public class Display01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入key：");
        String key = scanner.next();
        switch (key) {
            case "1":
                //静态加载，编译时就会报错
                //Dog d = new Dog();
                //d.cry();
                break;
            case "2":
                //动态加载 只有用到时才会报错
                Class<?> dog = Class.forName("Dog");
                Object o = dog.newInstance();
                Method cry = dog.getMethod("cry");
                cry.invoke(o);

                System.out.println("ok");
                break;
            default:
                System.out.println("do nothing..");
        }
    }
}
