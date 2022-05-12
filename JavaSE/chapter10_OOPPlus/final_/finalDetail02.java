package chapter10_OOPPlus.final_;

public class finalDetail02 {
    //如果是 静态final属性 只能在以下两种中赋值  【因为是类先加载 static】
    //1、初始化时赋值
    private static final int n1 = 100;
    private static final int n2;

    public finalDetail02() {
        //静态final属性 不能在构造器中赋值
//        n2 = 200;
    }

    {
        //静态final属性 不能在普通代码块中赋值
//        n2 = 200;
    }

    static {
        //静态final属性 能在静态代码块中赋值
        n2 = 200;
    }

}
