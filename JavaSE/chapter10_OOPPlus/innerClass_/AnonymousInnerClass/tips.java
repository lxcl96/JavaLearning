package chapter10_OOPPlus.innerClass_.AnonymousInnerClass;

public class tips {
    public static void main(String[] args) {
        System.out.println( new AAAAAA().getClass());
        System.out.println( new AAAAAA().getClass().getName());
    }
}
class AAAAAA {}
/*
    匿名内部类***：
    说明：匿名内部类是定义在 外部类的局部位置 比如方法中。【并且没有类名】
    【本质】1、本质是对象 2、本质是内部类 3、本质该类没有名字，但是系统运行时有名字 4、本质同时还是一个对象（可直接使用）
    I：匿名内部类的基本语法
    new 类或接口(参数列表) {
        类体；
    }；  AnonymousInnerClass.java

    II：匿名内部类的语法比较奇特，这是因为匿名内部类既是一个类的定义，同时它本身也是一个对象。
     因此从语法上看，它既有定义类的特征，也有创建对象的特征，这从AnonymousInnerClass.java可以看出。因此可以调用匿名内部类的方法
    III：可以直接访问外部类的所有成员，包括私有的
    IV：不能添加访问修饰符，因为它本身就是一个局部变量
    V：作用域：匿名内部类仅仅可用在方法和代码块中
    VI：匿名内部类----直接方法-----外部类的所有成员
    VII：外部其他类Other 不能访问匿名内部类【因为匿名内部就是一个局部变量 】
    VIII：如果匿名内部类和外部类的成员发发生重名时，匿名内部类访问时遵循就近原则即总是匿名内部类的成员。 【和局部内部类一样】
     如果想访问外部类的成员 【外部类名.this.成员】  【其中外部类名.this 就是外部类的对象，谁调用这个函数就是谁】


    匿名内部类的使用场景***：
    1、当作实参传递，简洁高效 AnonyInnerClassExercise01.java

 */