package chapter14_Collect_.Set_.HashSet_;

import chapter08_intermediate.Polymorphism.PolyIntroduce.Dog;

import java.util.HashSet;
import java.util.Set;

public class HashSet01_ {
    public static void main(String[] args) {
        Set set = new HashSet();
        //说明 到底有没有加入进去会返回一个boolean值
        System.out.println(set.add("john"));
        System.out.println(set.add("lucy"));
        System.out.println(set.add("john"));
        System.out.println(set.add("jack"));
        System.out.println(set.add(null));

        System.out.println(set);
        set.remove("john");
        System.out.println(set);

        //5、不能用重复的元素/或对象 【地址相同的，地址不同但是内容相同的可以】
        set = new HashSet();
        System.out.println("newSet=" + set);
        System.out.println(set.add("lucy"));
        System.out.println(set.add("lucy"));//false
        //需要看源码
        System.out.println(set.add(new String("lucy")));//true  其实答案是false
        System.out.println(set.add(new String("lucy")));//false
        System.out.println(set.add(new String("lucy").intern()));//false

        System.out.println(set.add(new Dog("tom")));
        System.out.println(set.add(new Dog("tom")));//true
        System.out.println(set);

    }
}
