package chapter07_Class.Constructor;
/*
构造器也叫构造方法、构造函数 是类的一种特殊方法，主要作用是完成对对象的初始化赋值（不是新建，开辟空间new）
特点：
    1、方法名必须和类名一致
    2、没有返回值
    3、在创建对象时，系统会自动调用该类的构造器完成对对象的初始化*（就是在new 类时自动调用了构造器）

 基本语法：
 [修饰符] 方法名(形参列表) {
    方法体;
 }

 */
public class Constructor01 {
    public static void main(String[] args) {
        //构造器 在创建的同时 初始化
        Person p1 = new Person("jack", 22);
        System.out.println(p1.name + p1.age);
    }
}

class Person{
    String name;
    int age;

    //类似于__init__
    public Person(String pName, int pAge) {
        /*
        1、构造器没有返回值， 也不能写void
        2、构造器方法名和类名一致

         */
        name = pName;
        age = pAge;
    }
}