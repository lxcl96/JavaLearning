package chapter10_OOPPlus.innerClass_.staticInnerClass;


public class StaticInnerClass {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.hi();
        /*
            【为什么有时新建类要(),有时不要()呢？ 】
            这个是因为：
                新建类带括号的代表调用，                new Outer01();
                新建类不带括号的一般只有静态类才会这样用   new Outer01.Inner01();

                总之只要是static的就不需要()，直接调用即可
         */
        //外部其他类 访问 静态内部类
        //方法1：new 外部类名不要括号.静态内部类名要括号
        // 这是因为静态内部类是静态的 就可以通过类名直接访问（前提是满足访问权限）
        new Outer01.Inner01().say();

        //方法二：在外部类中写一个方法，返回静态内部类【和成员内部类一样】
        outer01.getInnerClass().say();

        //方法二：优化 将这个返回方法写出静态的
        Outer01.getInnerClass01().say();
    }
}

class Outer01 {
    private int n1 = 10;
    private static int n2 = 11;
    private static String name = "张三";
    public static void cry(){}
    public  void eat(){}

    //静态内部类
    public static class Inner01 {
        private int n2 = 99;

        public void say() {
            cry();
//            eat();////静态类不能直接访问非静态成员
//            System.out.println(n1);//静态类不能直接访问非静态成员
            System.out.println(name);
            System.out.println(n2);//静态内部类的
            System.out.println(Outer01.n2);//静态内部类的
        }
    }

    public void hi() {
        new Inner01().say();
    }

    public Inner01 getInnerClass() {
        return new Inner01();
    }

    public static Inner01 getInnerClass01() {
        return new Inner01();
    }
}