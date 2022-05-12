package chapter07_Class.This;

public class ThisDetail {
    public static void main(String[] args) {
        T t1 = new T();
        t1.info2();
    }
}
/*
1、this可以访问本类的属性，方法，构造器
2、this用来区分属性和局部变量
3、访问成员方法：this.info()或info()
4、访问构造器：在构造器中调用本类中另外一个构造器（overload） ，只能在构造器中使用 且this()构造器调用必须放在第一条
5、this只能在类中使用 不能在类外
 */
class T {
    //构造器
    public T() {

        //调用另一个构造器 必须要先调用另外一个构造器
        this("haha", 1);
        System.out.println("构造方法 T()");
    }

    public T(String name, int age) {
        System.out.println("构造方法 T(String name, int age)");

    }

    public void info1() {
        System.out.println("info1()方法...");
    }

    public void info2() {
        System.out.println("info2()方法...");
        //调用本类中 info1()方法  info1()或this.info1();
        this.info1();
    }

}