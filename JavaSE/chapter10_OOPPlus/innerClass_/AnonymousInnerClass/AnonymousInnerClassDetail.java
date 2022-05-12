package chapter10_OOPPlus.innerClass_.AnonymousInnerClass;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        new Outer05().f1();
    }
}

class Person {
    public void hi() {
        System.out.println("Person hi()");
    }

    public void print(int n1) {
        System.out.println("n1=" + n1);
    }
}

class Outer05 {
    private int n1 = 99;
    public void f1() {
        //创建匿名内部类
        Person p = new Person(){
//            @Override//重写了hi方法
//            public void hi() {
//                System.out.println("Outer05 hi()");
//            }
        };

        //如果匿名内部类重写了 基于类的方法，就会使用动态绑定机制调用 Outer05 hi()
        //如果匿名内部类没有重写 基于类的方法，就类似于继承类 调用Person hi()
        //总之就是 p接收的对象，运行时先找运行类型Outer05$1的方法，没有才去找编译类型Person的方法
        p.hi();
        System.out.println("匿名内部类可以访问外部类的所有成员，包括private：");
        p.print(n1);

        //匿名内部类的匿名对象
        new Person(){

        }.hi();
    }
}