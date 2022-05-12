package chapter10_OOPPlus.classVariable;

public class VisitStatic {
    public static void main(String[] args) {
        //类变量是随着类信息加载的，因此不实例化也可以访问
        System.out.println(A.name);
        A a = new A();
        System.out.println(a.name);
        a.name = "小狗";
        System.out.println(A.name);
        System.out.println(a.name);
    }
}

class A {
    //类变量 静态变量/静态属性
    public static String name = "小猪";
}