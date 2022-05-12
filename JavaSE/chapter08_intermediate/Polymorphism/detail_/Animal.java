package chapter08_intermediate.Polymorphism.detail_;

public class Animal {
    String name = "动物";
    int age = 10;
    public void eat() {
        System.out.println("吃");
    }

    private void run() {
        System.out.println("跑");
    }

    public void show() {
        //父类特有方法
        System.out.println("hello,你好");
    }
}
