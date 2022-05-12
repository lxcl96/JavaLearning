package chapter07_Class.Method;

public class MethodDetail {
    public static void main(String[] args) {
        A a = new A();
        a.sayOK();
    }
}
class A {

    public void print(int n) {
        System.out.println("A类中print函数输出：" + n);
    }

    public void sayOK() {
        //同一个类中方法 可以直接调用不需要实例化
        print(10);
        System.out.println("A类中sayOk函数继续");
        //不同类中方法 要先实例化类才可以继续使用 跨类的方法
        //B.print(10);  是错的
        B b = new B();
        b.print(10);
        System.out.println("A类中sayOk函数继续");
    }
}

class B {

    public void print(int n) {
        System.out.println("B类中print函数输出：" + n);
    }

}