package chapter10_OOPPlus.codeBlock;

public class codeBlockDetail {
    public static void main(String[] args) {
        //静态代码块最先比调用 【静态代码块>非静态代码块>其他】
        //1、创建对象实例时（new）
//        new AA();
        //2、创建子类对象实例时（new），父类也会被加载 而且父类代码块先被加载
//        new BB();
//        System.out.println("==============");
        //使用类的静态成员（静态属性和静态方法）时
//        System.out.println(Cat.n1);

        System.out.println("==============");
        //使用子类的静态属性，父类的静态代码块也会被调用
        //至于为什么结果不一样，因为很多输出 静态代码块最先被调用【随类加载时】  就可以把上面的注销掉看看
        System.out.println(AA.n1);
    }
}
class AA extends Cat{
    public static int n1 = 100;
    static {
        System.out.println("AA类的静态代码块1。");
    }
    //只使用类的静态成员时,类和其父类的普通代码块不会被执行
    {
        System.out.println("AA类的静态代码块2。");
    }
}

class BB extends AA {
    static {
        System.out.println("BB类的静态代码块1。");
    }
}

class Cat {
    public static int n1 = 100;
    static {
        System.out.println("Cat类的静态代码块1。");
    }

    {
        System.out.println("Cat类的静态代码块2。");
    }
}