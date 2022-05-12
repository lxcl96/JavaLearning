package chapter10_OOPPlus.interface_;

public class interface01 {

}

interface f1 {
    //属性
    public int n1 = 10;

    //静态方法
    public static void f1() {
        System.out.println("f1方法。");
    }

    public void f2();//抽象方法

    public default void f3() {
        System.out.println("f3"); //default 默认方法
    }

//    public void f4(){};//普通方法不行

}

//使用接口
class A implements f1 {
    @Override
    public void f2() {

    }
}