package chapter08_intermediate.AccessModifier.A;


//也可以修饰类，但是只有public和默认两种
public class Test {
    public static void main(String[] args) {
        //同包中类不需要引入
        A a = new A();
        //不同包要引入
        chapter08_intermediate.AccessModifier.B.A a1 = new chapter08_intermediate.AccessModifier.B.A();


        //调用的是 《同类》 都可以访问到  方法同理
        a.m1();
        //调用的是 《同包不同类》 n1 public，n2  protected和n3 默认可以访问到，但是n4 private访问不到  方法同理
        System.out.println("n1= " + a.n1 + " n2 = " + a.n2 + " n3 = " + a.n3 + " n4 = 访问不到 ");
        //调用的是 《子类》 n1 public，n2  protected可以访问到，但是n3 默认，n4 private访问不到   方法同理

        //调用的是 《不同包》 n1 public可以访问到，但是n2  protected和n3 默认,n4 private访问不到   方法同理
        System.out.println("a1.n1= " + a1.n1 + " a2.n2 = 访问不到" + " a1.n3 = 访问不到" + " n4 = 访问不到 ");


    }
}

class tiger{
    //有两个类 文件就会变成 test.java
}
