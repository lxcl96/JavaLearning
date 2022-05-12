package chapter10_OOPPlus.codeBlock;

public class tips2 {
    public static void main(String[] args) {

    }
}
/*
    重点***: codeBlockDetail02.java
      创建一个对象时,在一个类 调用的顺序是:① > ② > ③ 【static > 正常 >构造方法】
      ①调用静态代码块和静态属性初始化【初始化赋值】
        注意：静态代码块和静态属性初始化调用优先级是一样的，如果有多个静态代码块和静态属性初始化 则按照定义的顺序来


      ②调用普通代码块和普通属性初始化【初始化赋值】
        注意：普通代码块和普通属性初始化调用优先级是一样的，如果有多个普通代码块和普通属性初始化 则按照定义的顺序来


      ③调用构造方法
      这个是因为 在构造方法中

            结构如下
            class Test {
                public Test() {
                    super;
                    普通代码块; //所以才是【static代码块和属性 > 正常代码块和属性 >构造方法】
                    其余代码
                }
            }

 */