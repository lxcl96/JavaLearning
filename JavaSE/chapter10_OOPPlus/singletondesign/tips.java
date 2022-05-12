package chapter10_OOPPlus.singletondesign;

public class tips {
    public static void main(String[] args) {

    }
}

/*
    单例设计模式：（单个实例） 23中设计模式其中一个
    1、所谓的单例设计模式，就是采取一定的方法保证在整个软件系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法。

    2、单例设计模式方式：a）饿汉式  【类加载时就创建了，有可能会用不到】
                     b）懒汉式  【你不用他就不会创建，使用时才会创建】


        饿汉式：singleTon.java
            1、构造器私有化（防止类外直接new）
            2、类的内部创建对象
            3、向外暴露一个静态的公共方法。getInstance

        懒汉式：singleTon02.java
            1、构造器私有化（防止类外直接new）
            2、定义一个静态属性，引用本类。
            3、向外暴露一个静态的公共方法。getInstance 返回对象【方法内创建,需要判断此时引用是否为空，如果不为空就不要重复创建了】

        总结：饿汉式：静态属性声明
             懒汉式：静态方法声明


        应用：java.lang.Runtime 就是单例设计模式的 饿汉式


 */