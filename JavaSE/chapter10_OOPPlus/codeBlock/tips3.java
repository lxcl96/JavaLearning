package chapter10_OOPPlus.codeBlock;

public class tips3 {
    public static void main(String[] args) {

    }
}
/*
    在构造器中 隐藏了super和普通代码块 codeBlockDetail03.java
    //所以 父类的普通代码块比先于子类的普通代码块
    //父类的静态代码块 也要先于子类的静态代码块
    class A {
        public A() {
            super();
            本类普通代码块和普通属性;
            代码;
        }
    }


 */