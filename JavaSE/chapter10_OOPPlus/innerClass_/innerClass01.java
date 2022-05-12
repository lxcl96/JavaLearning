package chapter10_OOPPlus.innerClass_;

public class innerClass01 {

}

class Outer {
    //属性
    private int n1 = 100;
    //方法
    public void m1() {
        System.out.println("n1=" + n1);
    }
    //构造器
    public Outer(int n1) {
        this.n1 = n1;
    }
    //代码块
    {
        System.out.println("代码块");
    }
    //内部类
    class Inner {

    }
}