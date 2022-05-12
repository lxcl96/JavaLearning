package chapter10_OOPPlus.interface_;

public class tips2 {

}
/*
    注意事项
    1、接口也是抽象类，所以接口不能被实例化
    2、接口中所以的方法都是public方法，接口中抽象方法可以不用abstract 修饰
        void aaa();  实际上是  abstract void aaa();
    3、一个普通类实现接口，需要重写接口的所有抽象方法【所有，all】
    4、一个抽象类实现接口，可以不重写接口的方法【任意一个，0】
    5、一个类可以同时 实现/使用 多个接口 interfaceDetail01.java
    6. 接口中的属性只能是 final 而且是 public static final的
        int a=1; 实际上是 public static final int a=1;(而且必须初始化)
    7. 接口中属性的访问形式是: 接口名.属性
    8. 一个接口不能继承其他类,但是可以继承多个别的接口 interfaceDetail02.java
        接口不能继承:普通类和抽象类, 只能继承接口

    9. 接口的访问修饰只能是 public和默认的 与类相同
 */