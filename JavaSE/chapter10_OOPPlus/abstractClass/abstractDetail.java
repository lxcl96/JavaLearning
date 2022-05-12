package chapter10_OOPPlus.abstractClass;

/*
  1、抽象类没办法实例化(包括子类) new A();
  2、抽象类可以不包含抽象方法，但是有抽象方法一定是抽象类
  3、abstract只能用来修饰类和方法，不能用于修饰属性和其它的
  4、抽象类和普通类一样该有的都有 如：普通属性、普通方法和构造器
  5、抽象方法不能有主体/方法体{}
  6、如果一个类继承了抽象类，则它必须实现抽象类的所以抽象方法，除非它自己也是abstract抽象类
  7、抽象方法不能使用private、final和static,因为这些不能重写
 */
public class abstractDetail {
    public static void main(String[] args) {
        //1、抽象类没办法实例化 2、抽象类可以不包含抽象方法，但是有抽象方法一定是抽象类
//        new A();
    }
}
abstract class A {}
abstract class B {
    public int n1 = 10;
    public static String name = "haha";
    public void hi() {
        System.out.println("hello");
    }

    public B() {
    }

    public abstract void eat();
}
//父类是抽象类子类必须补写父类的抽象方法，除非该子类也为abstract抽象类
class C extends B {
    @Override
    public void eat() {

    }
}



//父类是抽象类子类必须补写父类的抽象方法，除非该子类也为abstract抽象类
abstract class D extends B {
    public void f1() {

    }
}