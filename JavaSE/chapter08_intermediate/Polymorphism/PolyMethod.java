package chapter08_intermediate.Polymorphism;

public class PolyMethod {
    public static void main(String[] args) {
        A a = new A();

        //我们通过不同的参数个数去调用sum方法，就会调用的方法
        //因此对sum方法来说，就是多种态度的体现
        System.out.println(a.sum(10, 20));
        System.out.println(a.sum(10, 20, 30));
    }
}

//重写和重载就体现多态
class B {
    public void say() {
        System.out.println("B say() 方法被调用。。。");
    }
}
class A extends B {
    public int sum(int n1, int n2) {
        return n1 + n2;
    }
    public int sum(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }

    @Override
    public void say() {
        System.out.println("A say() 方法被调用。。。");
    }
}