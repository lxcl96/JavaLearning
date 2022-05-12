package chapter08_intermediate.Polymorphism._dynamic_importance;

public class DynamicBind {
    public static void main(String[] args) {
        A a = new B();//向上转型

        // 如果子类的sum()方法注销，答案是：30
        /*
        运行过程：先找B的sum()没有，继承发挥作用就去找A的sum，然后调用方法就会用到动态绑定机制 去运行类型B中找getl
            找到了，然后返回i，i不是方法是属性，所以i的为20【如果B中未定义i才会去找A，这是i才为10】

            B中i=20 注销，此时答案为：20

         */
        System.out.println(a.sum());//40


        // 如果子类的sum1()方法注销，答案是：20
        System.out.println(a.sum1());//30

    }
}
/*
    动态绑定：【方法有动态绑定机制，属性没有】
        1、当调用对象方法的时候，该方法会和该对象的 内存地址/运行类型 绑定 【向上转型 调用方法先找子类】
        2、当调用对象属性时，没有动态绑定机制，哪里声明，哪里使用。
 */
class A {
    public int i = 10;
    public int sum() {
        return getl() + 10;
    }
    public int sum1() {
        return i + 10;
    }

    public int getl() {
        return i;
    }
}

class B extends A {
//    public int i = 20;
//    public int sum() {
//        return getl() + 20;
//    }
//    public int sum1() {
//        return i + 10;
//    }

    public int getl() {
        return i;
    }
}