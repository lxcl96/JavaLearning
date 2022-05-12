package chapter11_EnumerationAndAnnotation.Enumeration;

public class tips {

}
/*
    枚举：Enumeration
    1、枚举是一组常量的集合
    2、可以理解：枚举属于一种特殊的类，里面只包含一组有限的特定的对象

    枚举的两种实现方式：
    方法一：自定义枚举  Enumeration02.java
        注意：
        1、类中不需要提供SetXXX方法，因为枚举对象通常为只读
        2、对枚举对象/属性使用final + static 实现底层优化
        3、枚举对象名通常使用全部大写，常量的命名规范
        4、枚举对象根据需要，也可以有多个属性 //Enumeration02.java
        步骤：
            a、构造器私有化
            b、类内创建一个public static final 引用名 = new 类();
            c、外面直接访问引用名
    方法二：使用enum关建字实现枚举【对象是static和final】  Enumeration03.java
        注意：
        1、当我们使用Enum关建字来开发一个枚举类时，其实是继承了Enum类【如何证明？ 使用反编译命令javap查看】
        2、将public static final 引用名 = new 类(); 简化为 枚举对象1(),枚举对象2();
        3、如果枚举是无参构造器则可以写成【枚举对象1()或枚举对象1】
        4、有多个枚举对象时用 逗号分隔，最后用分号
        5、枚举对象的声明必须放在枚举类的行首
        步骤：
            a、使用关建字enum 替换class
            b、定义枚举值：枚举变量1(枚举值)，枚举变量2(枚举值);【注意，多个枚举变量时用逗号，最后再用分号 且必须放在第一排】
            c、使用关建字enum来实现枚举，必须要把枚举变量即第二步放在最开始的位置上
            d、使用直接 枚举名.枚举变量
 */