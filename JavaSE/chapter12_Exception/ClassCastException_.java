package chapter12_Exception;

public class ClassCastException_ {
    public static void main(String[] args) {
        A b = new B();//向上转型
        B b1 = (B)b;//向下转型

        C c = (C)b;//B和C没有继承关系，转换失败
    }
}

class A{}
class B extends A{}
class C extends A{}
