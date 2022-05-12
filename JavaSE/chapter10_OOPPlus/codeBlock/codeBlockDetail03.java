package chapter10_OOPPlus.codeBlock;

public class codeBlockDetail03 {
    public static void main(String[] args) {
        new BBB();
        /*
        //1、AAA()的构造器 被调用..2、BBB的普通代码块..3、BBB()的构造器 被调用...

        //1、AAA的普通代码块..2、AAA()的构造器 被调用..3、BBB的普通代码块..4、BBB()的构造器 被调用...
         */
    }
}
class AAA {
    {
        System.out.println("AAA的普通代码块..");
    }
    public AAA() {
        System.out.println("AAA()的构造器 被调用...");
    }
}

class BBB extends AAA {
    {
        System.out.println("BBB的普通代码块..");
    }
    public BBB() {
        //super
        //本类的代码块
        System.out.println("BBB()的构造器 被调用...");
    }
}

