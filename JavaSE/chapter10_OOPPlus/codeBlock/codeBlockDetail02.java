package chapter10_OOPPlus.codeBlock;

public class codeBlockDetail02 {
    public static void main(String[] args) {
        CC cc = new CC();
        /*
         n1 = 100
        静态static代码块 1
        静态static代码块 2
        静态f1被调用
        ***n3 = 300
        n2 = 200
        代码块 1
        代码块 2

         */
    }
}
class CC {
    private int n3 = f1();
    private static int n1 = 100;
    private int n2 = 200;


    static {
        System.out.println("静态static代码块 1");
    }
    {
        System.out.println("代码块 1");
    }
    {
        System.out.println("代码块 2");
    }
    static {
        System.out.println("静态static代码块 2");
    }

    public static int f1() {
        System.out.println("静态f1被调用");
        return 300;
    }
}