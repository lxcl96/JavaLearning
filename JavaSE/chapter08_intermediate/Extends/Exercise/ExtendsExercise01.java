package chapter08_intermediate.Extends.Exercise;

public class ExtendsExercise01 {
    public static void main(String[] args) {

        /*
         * 问：B b = new B()会输出什么？
         * 答：   a
         *       b name
         *       b
         */
        B b = new B();
    }
}
class A {
    A() {
        System.out.println("a");
    }
    A(String name) {
        System.out.println("a name");
    }
}

class B extends A {
    B() {
        this("abc");//有this就没有super 隐藏的super也没有
        System.out.println("b");
    }
    B(String name) {
        //有个隐藏的 super
        System.out.println("b name");
    }
}