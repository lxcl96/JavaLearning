package chapter08_intermediate.Polymorphism.detail_;

public class Cat extends Animal {
    char sex = '男';
    String name = "小花猫";
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void catmouse() {
        //Cat特有方法
        System.out.println("猫抓老鼠");
    }
}
