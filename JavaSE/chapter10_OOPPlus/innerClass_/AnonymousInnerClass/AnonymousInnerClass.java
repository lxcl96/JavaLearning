package chapter10_OOPPlus.innerClass_.AnonymousInnerClass;
/*
 *演示匿名内部类的使用
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}
class Outer04 { //外部类
    private int n1 = 10;

    public void method() {
        //基于接口的匿名内部类
        //为什么使用匿名对象？ 有时候该接口只使用一次，为此特意建立一个常规对象有点浪费。所以采用匿名内部类只使用一次，类似于匿名对象
        //不接收就是匿名对象，接收就是匿名内部类 【用的是接口的多态】
        //tiger 的编译类型是 A
        //tiger 的运行类似是 匿名内部类 【接口不是类，所以运行类型不是A】

        /*
            底层代码实际上是这样的 创建一个临时类面使用了接口
            class Outer04$1 implements A{
                @Override
            public void cry() {
                System.out.println("老虎叫唤。。。");
            }
            }
         */
        A tiger = new A() { //基于接口的匿名内部类
            @Override
            public void cry() {
                System.out.println("老虎叫唤。。。");
            }
        };

        /*
            底层代码实际上是这样的 创建一个临时类面继承了Father类
            class Outer04$2 extends Father{
                @Override
                public void test() {
                    System.out.println(getClass());
                    System.out.println("匿名内部类基于类 在测试。。。");
                }
            }
         */
        Father father = new Father("小明"){//基于类的匿名内部类  有参构造器初始化
            @Override
            public void test() {
                System.out.println(getClass());
                System.out.println("匿名内部类基于类 在测试。。。");
            }
        };

        father.test();
        //原来是这样，我终于知道为什么有的class文件含有$1 $2这样的，原来是运行时匿名内部类创建的临时类
        System.out.println("tiger的运行类型是匿名内部类，类名为：" + tiger.getClass().getName());
        tiger.cry();
        System.out.println("=======================直接使用匿名对象，匿名内部类的匿名对象");
        new A() {
            @Override
            public void cry() {
                System.out.println(getClass());
                System.out.println("小狗汪汪叫。。。");
            }
        }.cry();

        //基于抽象类的 匿名内部类必须要重写抽象方法
        Animal a = new Animal() {
            @Override
            void eat() {
                System.out.println("eat");
            }
        };
        a.eat();
    }
}


interface A { //接口
    public void cry();
}

class Father {
    public Father(String name) {
        super();
    }

    public void test() {}
}

abstract class Animal{//抽象类
    abstract void eat();
}