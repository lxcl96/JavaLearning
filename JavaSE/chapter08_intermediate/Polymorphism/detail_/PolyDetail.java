package chapter08_intermediate.Polymorphism.detail_;

public class PolyDetail {
    public static void main(String[] args) {
        //向上转型：父类的引用指向子类的对象
        Animal cat = new Cat();
        //可以访问 父类的所有成员（遵守访问权限啊），包括子类和父类重写方法
        // 【子类相同属性访问不了】 其实此时cat可以理解为就是 animal的对象 只是重写的函数特殊
        System.out.println("age=" + cat.age);
        System.out.println("name=" + cat.name);
        cat.eat();
        //可以访问 父类特有属性
        cat.show();

        //不能访问子类 的特有方法和所有属性 ，cat.catchmouse和cat.sex
        //这是因为在编译的时候，javac能调用哪些成员【属性和方法】是由编译类型决定的Animal



        /*
            但是就是想要访问子类的成员呢?
            向下转型即 强制转换进制：引用名 = (子类类型)父类引用
         */

//        Cat newCat;
        Cat newCat = (Cat)cat;//父类强制转换为子类  即 double变成int 需要一个子类类型 来接收
        System.out.println("==============");
        System.out.println("age=" + newCat.age);
        System.out.println("name=" + newCat.name);
        System.out.println("sex=" + newCat.sex);
        newCat.eat();
        newCat.show();
        newCat.catmouse();


        // 不可以，向下转型 可以理解为 【还原 从父类变成子类，但不是兄弟】
        //编译没问题 但是运行会报错
        Dog newDog = (Dog) cat;

    }
}
