package chapter10_OOPPlus.innerClass_.staticInnerClass;

public class tips {

}
/*
    静态内部类： StaticInnerClass.java
    说明：静态内部类是定义在外部类的成员位置上的，并且由static修饰
    1、静态内部类可以直接访问外部类的所有静态成员，包含私有的，【但是不能访问非静态的】
    2、静态内部类可以添加访问修饰符【四个都可以】 因为它本质上就是成员
    3、作用域：同其他的成员，为整个类体
    4、静态内部类---访问---外部类 【直接访问，所有的静态成员/非静态的不行】
    5、外部类---访问---静态内部类 【创建对象，在访问】
    6、外部其他类---访问---静态内部类
        方法一：new 外部类.静态内部类 （因为是静态的所有内部类不需要再创建了）

        方法二：在外部类中写一个方法，返回静态内部类【和成员内部类一样】
            优化：直接把这个方法写出静态的，都不需要创建外部类对象直接调用

     7、如果外部类和静态内部类的成员重名时，一样遵循就近原则 即在静态内部类中访问的重名成员都是静态内部类成员
        如果想要访问 外部类的重名成员 方法：【外部类名.成员】
        【这个重名成员必须是静态的，不然根本访问不了啊】



 */