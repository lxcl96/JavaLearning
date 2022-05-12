package chapter13_CommonClass.StringClass_;

public class tips {

}
/*
    String赋值的两种方式：
    方式一：直接赋值  String s = "Hello"
    方式二：调用构造器赋值 String s = new String("Hello")

    1、方式一：先从常量池中查看是否有"Hello" 的数据空间,如果有,则直接指向;如果没有则重新创建,然后指向.
        s最终指向的是常量池的空间地址 String02.java

    2、方式二：现在堆中创建空间，里面维护values[]的属性，指向常量池的"Hello"空间。
        如果常量池中没有"Hello",则重新创建，如果有，则直接通过value指向。
        s最终指向为堆中的内存地址

 */
