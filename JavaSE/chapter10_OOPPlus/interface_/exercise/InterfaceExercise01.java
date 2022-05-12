package chapter10_OOPPlus.interface_.exercise;

public class InterfaceExercise01 {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.a);//23 正确
        System.out.println(A.a);//23 正确
        System.out.println(B.a);//23  我回答是错误，实际是正确的
    }
}

interface A {
    int a = 23; //等价于 public static final int a = 23；
}
//可以理解为B 继承了A当然也会有A的a
class B implements A {}
