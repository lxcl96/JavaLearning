package chapter08_intermediate.Polymorphism;

public class PolyObject {
    public static void main(String[] args) {
        //对象多态的 特点
        //使用 自身 编译类型 【编译类型是Animal】
        Dog dog = new Dog();
        dog.say();//

        //使用父类 编译类型
        Animal dog1 = new Dog();
        dog1.say();//执行到该行时，dog1运行类型是Dog 所以运行Dog中的say
        //更改 运行类型 【编译类型仍是Animal】
        dog1 = new Cat();
        dog1.say();

        //Dog animal = new Animal(); 【子类 = 父类 出错】 类似于 【 int = double】
    }
}

class Animal {
    public void say() {
        System.out.println("Animal say() 中 动物 在叫。。。");
    }
}

class Dog extends Animal{
    public void say() {
        System.out.println("Dog say() 中 狗 在叫。。。");
    }
}

class Cat extends Animal{
    public void say() {
        System.out.println("Cat say() 中 猫 在叫。。。");
    }
}