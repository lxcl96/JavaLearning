package chapter10_OOPPlus.abstractClass;

//包含抽象方法的类必须是抽象类
public abstract class tips {
    private String name;

    //定义抽象方法，没有方法体
    public abstract void eat();
}
/*

    抽象类：
      适用情况：当父类的某些方法，需要声明，但是又不确定如何实现时，可以将其声明为抽象方法，那么这个类就是抽象类。
      具体是由子类来实现（扩展）该抽象方法

      所谓的抽象方法就是没有方法体{}，只有声明
      有抽象方法则该类必须要为抽象类


      格式：
      访问修饰符 abstract 类名{

        访问修饰符 abstract 返回类型 方法名(形参); //没有方法体{}
      }
 */