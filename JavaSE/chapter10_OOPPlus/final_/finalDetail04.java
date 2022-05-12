package chapter10_OOPPlus.final_;

public class finalDetail04 {
    public static void main(String[] args) {
        System.out.println(AAA.n1);
    }
}

class AAA{
    //这样使用会加载整个类信息，
//    public static int n1 = 100;   //输出静态代码块！  100
    public static final int n1 = 100;//这样只会 输出 100
    static {
        System.out.println("静态代码块！");
    }
}