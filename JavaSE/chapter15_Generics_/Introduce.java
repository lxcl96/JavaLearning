package chapter15_Generics_;

import java.util.ArrayList;

public class Introduce {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Dog("小黄", 1));
        list.add(new Dog("大黄", 5));
        list.add(new Dog("小黑", 2));
        list.add(new Cat("大咪", 3));

        /**
         * 缺点：
         *  1、无法做到类型约束 Dog
         *  2、如果数据量很大，频繁转换导致效率下降
         */
        for (Object o: list) {
            //问题出现 如果不小心加入一只猫Cat类型，则下面代码就会报错
            Dog dog= (Dog)o;
            System.out.println(dog.getName() + dog.getAge());
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
