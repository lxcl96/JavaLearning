package chapter10_OOPPlus.singletondesign;

public class singleTon02 {
    public static void main(String[] args) {
        Cat newCat = Cat.getInstance();
        Cat instance = Cat.getInstance();

        System.out.println(instance);

        System.out.println(newCat);
        System.out.println(newCat == instance);//判断这俩地址是否相同
    }
}
//希望程序在运行时，只能创建一个Cat  懒汉式/单例模式
class Cat {
    private String name;
    //2、定义一个静态属性，引用本类
    private static Cat cat;//并没有开辟空间


    //1、构造器私有化（防止类外直接new）
    private Cat(String name) {
        this.name = name;
    }

    public static Cat getInstance() {
        if (cat == null) {//如果还没有创建对象
            cat = new Cat("小红");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}