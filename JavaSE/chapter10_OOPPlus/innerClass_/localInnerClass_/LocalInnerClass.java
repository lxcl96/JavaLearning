package chapter10_OOPPlus.innerClass_.localInnerClass_;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        System.out.println("outer02的HashCode()=" + outer02.hashCode());
        //Outer02.this就是调用的对象 可以通过hashcode分辨
        outer02.m1();//outer02调用了m1 所以本质上outer02 就是Outer02.this
    }
}

class Outer02 { //外部类
    private int n1 = 100;
    public int n = 300;
    private void m2(){};


    public void m1() { //外部方法

        //局部内部类  一般在外部类方法中
        final class Inner02 {//不能加访问修饰符 public和默认 可以加final
            public int n = 200;
            public void f1() {
                System.out.println("n1=" + n1);
                m2();
                //外部类成员 和 局部内部类成员变量重名 遵循就近原则，显示的是 n=200
                //n 等价于 this.n代表本类 局部内部类， Outer02.this.n代表外部类成员
                //Outer02.this本质上就是外部类的对象，即哪个对象调用了m1，Outer02.this就是哪个对象
                System.out.println("n=" + n + " 外部类成员值为：n=" + Outer02.this.n);
                System.out.println("this的HashCode()=" + this.hashCode());//此hashCode为当前内部类的hashcode
                System.out.println("Outer02.this的HashCode()=" + Outer02.this.hashCode());
            }
//            m2();//放这里肯定错了啊，这是类的成员位置，不是调用应该放在方法中调用
        }

        //外部内方法或代码块 使用局部内部类
        new Inner02().f1();
    }

}

//外部内部类
class Other{
    public int n = 300;
}