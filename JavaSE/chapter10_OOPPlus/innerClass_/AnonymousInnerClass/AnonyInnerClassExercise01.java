package chapter10_OOPPlus.innerClass_.AnonymousInnerClass;

public class AnonyInnerClassExercise01 {
    public static void main(String[] args) {
        //补充接口的方法，同时传递参数
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("这是一幅名画。。。  匿名内部类方法");
            }
        });

        //传统写法 需要定义一个类使用IL 然后补充show方法【因为接口不能直接创建对象】
        //需要额外创建 一个类
        f1(new Test());

    }

    //桥梁 使用接口
    public static void f1(IL il) {
        il.show();
    }
}

interface IL {//接口
    void show();
}

//传统类实现IL
class Test implements IL {
    @Override
    public void show() {
        System.out.println("这是一幅名画。。。  传统方法");
    }
}

