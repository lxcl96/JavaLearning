package chapter08_intermediate.Polymorphism.PolyIntroduce;

public class Poly01 {
    public static void main(String[] args) {
        Dog dog = new Dog("阿黄");
        Cat cat = new Cat("咪咪");
        Bone bone = new Bone("大棒骨");
        Fish fish = new Fish("白条");
        Master tom = new Master("Tom");

        //假如后面 还有很多宠物 鹦鹉 猪等等 每个都要写一个重载的方法 很麻烦  方法的复用性不高，而且不利于代码的维护

        // 多态可以解决这类问题【其实就是子类太多了，一个一个写特有的方法，可以用他们的父类来写一个公共的方法 因为父类兼容子类】

        tom.feed(dog, bone);
        tom.feed(cat, fish);
        //使用多态解决这个问题 见Master.java
        Animal pig = new Pig("猪猪");
        Food rice = new Rice("大米饭");
        tom.feed(pig, rice);


    }
}

//主人类Master 拿食物类Food 给动物类Animal
