package chapter14_Collect_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Dog("阿黄", 3));
        list.add(new Dog("小黑", 1));
        System.out.println("常态输出：" + list);
        System.out.println("==使用iterator输出==");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next =  it.next();
            System.out.println(next);

        }
        System.out.println("==使用增强for输出==");
        for (Object obj:list) {
            System.out.println(obj);
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

    @Override
    public String toString() {
        return "[" + name + ", " + age + ']';
    }
}