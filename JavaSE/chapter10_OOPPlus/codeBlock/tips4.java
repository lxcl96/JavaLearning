package chapter10_OOPPlus.codeBlock;

public class tips4 {
    public static void main(String[] args) {

    }
}

/*
 class A {
        public A() {
            super();
            本类普通代码块和普通属性;
            代码;
        }
    }

    有继承关系的代码块调用顺序 【记住上面结构就ok了】  codeBlockDetail04.java
        6) 创建一个子类对象时(继承关系)，他们的【静态代码块，静态属性初始化，普通代码块，普通属性初始化，构造方法】的调用顺序如下：
            ⑨父类的静态代码块和静态属性(优先级一样，按定义顺序执行)
            ②子类的静态代码块和静态属性(优先级一样，按定义顺序执行)
            ③父类的普通代码块和普通属性初始化(优先级一样，按定义顺序执行)
            ④父类的构造方法
            ⑤子类的普通代码块和普通属性初始化(优先级一样，按定义顺序执行)
            ⑥子类的构造方法
 */