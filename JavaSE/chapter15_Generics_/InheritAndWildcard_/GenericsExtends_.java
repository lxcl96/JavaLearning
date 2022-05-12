package chapter15_Generics_.InheritAndWildcard_;

import java.util.ArrayList;
import java.util.List;

public class GenericsExtends_ {
    public static void main(String[] args) {
        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<AA> list3 = new ArrayList<>();
        ArrayList<BB> list4 = new ArrayList<>();
        ArrayList<CC> list5 = new ArrayList<>();
        //printCollection1都可以，<?>接受任意类型
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);

        //printCollection2
//        printCollection2(list1);//不可以
//        printCollection2(list2);//不可以
//        printCollection2(list3);//可以
//        printCollection2(list4);//可以
//        printCollection2(list5);//可以

        //printCollection3
//        printCollection3(list1);//可以
//        printCollection3(list2);//不可以
//        printCollection3(list3);//可以
//        printCollection3(list4);//不可以
//        printCollection3(list5);//不可以

    }

    //【下面三个是使用泛型，不是泛型方法】
    //使用List泛型类，用<?>替换E 表示任意类型都可以
    public static void printCollection1(List<?> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }
    //只接受AA以及其子类
    public static void printCollection2(List<? extends AA> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }
    //只接受AA以及其父类
    public static void printCollection3(List<? super AA> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }
}

class AA{}

class BB extends AA{}

class CC extends BB{}