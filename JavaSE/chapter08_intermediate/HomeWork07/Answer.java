package chapter08_intermediate.HomeWork07;

public class Answer {
    public static void main(String[] args) {

    }
}
/*

        Test
        Demo
        Rose
        Jack

        john
        Jack

        注意：答案没问题，new Demo().test();//没有引用 所以是匿名对象用法 用了一次就回收了
        new Demo("john").test();中调用到父类的Test()导致父类的name变成了john  这里就是基础变量没有动态绑定机制
        基础变量 没有动态绑定机制   那里调用就改 那里的值
        方法      有
 */