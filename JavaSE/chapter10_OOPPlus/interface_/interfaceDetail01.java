package chapter10_OOPPlus.interface_;

public class interfaceDetail01 implements IA1, IA2{
    //一个类可以使用多个接口

    @Override
    public void f1() {

    }

    @Override
    public void f2() {

    }

    @Override
    public void f3() {

    }
}
interface IA1 {
    void f1();
    void f3();
}

interface IA2 {
    void f2();
    void f3();
}