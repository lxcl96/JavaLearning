package chapter14_Collect_.List_.ArrayList_;

import java.util.ArrayList;

public class ArrayListDetail {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        //1、ArrayList可以存放所有的数据元素，甚至是空元素null,可以重复多个
        arrayList.add("haha");
        arrayList.add(null);
        arrayList.add("pig");
        arrayList.add(null);
        System.out.println(arrayList);
    }
}
