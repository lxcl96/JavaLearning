package chapter10_OOPPlus.Polymorphism;

public class InterfacePolyParameter {
    public static void main(String[] args) {
        //接口体现的多态
        //可以看到接口可以接收 实现接口类的实例
        IF if01 = new Monster();
        if01 = new Car();
        //没有实现接口 的类的实例就无法接收  类型不一致
//        if01 = new AAA();


        //继承体现的多态
        AAA aaa = new BBB();
        aaa = new CCC();
    }
}

interface IF{}

class Monster implements IF{}

class Car implements IF{}
class AAA{}

class BBB extends AAA{}
class CCC extends AAA{}