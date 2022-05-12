package chapter08_intermediate.AccessModifier.B;

public class A {
    //四个不同的访问修饰符
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public void m1() {
        //同类访问
        //该方法可以访问此四个属性
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
    }
}
