package chapter14_Collect_.List_.list_;

import java.util.ArrayList;
import java.util.List;

public class ListMethod_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        List list2 = new ArrayList();
        list2.add(1);
        list2.add("tom");
        list2.add("2");
        list2.add('3');
        list2.add("String 4");
        list.add("jack");
        list.add("tom");
        list.add("mary");
        list.add("ly");
        list.add(3, "hsp");//插入不是替换
        System.out.println(list);
        list2.add(list);//把集合当成一个元素 插入
        list2.add("---Split---");
        list2.addAll(list);//把集合当初n个元素 插入
        System.out.println(list2);
        System.out.println(list2.indexOf("jack"));
        System.out.println(list2.lastIndexOf("tom"));
        list2.set(8, "tom2");
        System.out.println(list2);
        System.out.println(list2.subList(3, 6));//返回的范围为 [3,6) 前闭后开

    }
}
