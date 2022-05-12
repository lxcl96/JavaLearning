package chapter23_reflection_.Class_;

import chapter23_reflection_.introduce.Car;

import java.io.Serializable;

/**
 * @Author : Ly
 * @Date : 2022/4/15
 * @Description : 演示哪些类有class对象
 */
public class AllTypeClass {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;//外部类
        Class<Serializable> serializableClass = Serializable.class;//接口
        Class<int[]> aClass = int[].class;//数组
        Class<Integer[][]> aClass1 = Integer[][].class;//数组

        Class<Deprecated> deprecatedClass = Deprecated.class;//注解

        Class<Thread.State> stateClass = Thread.State.class;//枚举

        Class<Integer> integerClass = int.class;//基本数据类型

        Class<Class> classClass = Class.class;//Class类

        //匿名内部类
        Car car = new Car() {
            void f2(){
                System.out.println("匿名内部类");
            }
        };
        Class<? extends Car> aClass2 = car.getClass();
        System.out.println(aClass2);


        //局部内部类
        class Part {
            void f3() {
                System.out.println("局部内部类");
            }
        }
        Class<Part> partClass = Part.class;
        System.out.println(partClass);


    }


}
