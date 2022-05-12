package chapter10_OOPPlus.final_;

public class finalDetail01 {
    //1、final属性在初始化时赋值
    private final int n1 = 100;
    //2、final属性在构造器中赋值
    private final int n2;
    //3、final属性 在代码块中被赋值
    private final int n3;

    public finalDetail01() {
        n2 = 200;
    }

    {
        n3 = 300;
    }
}
