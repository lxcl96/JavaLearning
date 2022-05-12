package chapter08_intermediate.Polymorphism.PolyIntroduce;

public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    //使用多态 通过传递父类的 编译类型 来复用
    //【其实就是子类太多了，一个一个写特有的方法，可以用他们的父类来写一个公共的方法 因为父类兼容子类】
    public void feed(Animal animal, Food food) {
        System.out.println("主人" + this.name + "给" + animal.getName() + "吃" + food.getName());
    }
//    //主人 给 小狗 喂食
//    public void feed(Dog dog, Bone bone) {
//        System.out.println("主人" + this.name + "给" + dog.getName() + "吃" + bone.getName());
//    }
//
//    //主人 给 小猫 喂食
//    public void feed(Cat cat, Fish fish) {
//        System.out.println("主人" + this.name + "给" + cat.getName() + "吃" + fish.getName());
//    }

    //。。。
    //假如后面 还有很多宠物 鹦鹉 猪等等 每个都要写一个重载的方法 很麻烦  方法的复用性不高，而且不利于代码的维护
    // 多态可以解决这类问题

}
