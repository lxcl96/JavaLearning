package chapter15_Generics_;

import java.util.ArrayList;

public class GenericsOfIntroduce {
    public static void main(String[] args) {
        //使用泛型  <类型>
        //1、ArrayList<Dog>表示存放在集合list中的只能是Dog【包括子类】类型
        //  如果放入别的类型Cat 编译器就会直接报错
        //Dog不是泛型，只是一种类型 E是泛型表示一种数据类型，担不是具体的【所以不能说Dog是泛型，Dog只是泛型指定的类型】
        ArrayList<Dog> list = new ArrayList<Dog>();
        list.add(new Dog("小黄", 1));
        list.add(new Dog("大黄", 5));
        list.add(new Dog("小黑", 2));
        //list.add(new Cat("大咪", 3));

        //2、遍历也就变得很方便，因为指定类型了，就可以用Dog直接存取 不需要向下转型了
        for (Dog d: list) {
            System.out.println(d.getName());
        }

    }
}
