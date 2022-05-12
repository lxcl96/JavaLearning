package chapter10_OOPPlus.interface_;

public class tips {

}
/*  【接口：高级的抽象类】
    接口: 就是给出一些没有实现的方法,封装到一起,到某个类要使用的时候,再根据具体情况把这些方法写出来
    接口语法:
    interface 接口名{
        属性;
        方法;（abstract抽象方法，static静态方法，default默认方法）
    }
    使用语法:
    class 类型 implements 接口名 {
        自己的属性;
        自己的方法;
        必须实现接口的抽象方法;
    }


    注意:interface01.java
        1. jdk7.0前 接口里的方法都没有方法体 【即都是抽象方法】  可以省略abstract
        2. jdk8.0后接口类可以有静态方法, 默认方法(需要使用default)也就是说接口中可以有方法的具体实现{属性;代码;}
                【即有静态方法，也有抽象方法，无普通方法】

 */