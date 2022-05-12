package chapter10_OOPPlus.final_;

public class final01 {
    public static void main(String[] args) {
        A a = new A();
        //不能修改 final的属性
//        a.n1 = 200;
    }
}


final class A {
    public final int n1 = 100;
    public final static void print(){
        System.out.println("哈哈哈");
    }

    public void f1() {
        final int count = 0;
        //final修饰的局部变量不能修改
//        count++;
        System.out.println(count);
    }
}

class B{
    //final方法不能被重写
//    public final static void print(){
//        System.out.println("哈哈哈");
//    }
}