package chapter14_Collect_.Set_.LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetSource {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(new Customer("刘", 1001));
        set.add(123);
        set.add("HSP");
        System.out.println(set);
        /**
         *  1、LinkedHashSet加入顺序和元素的取出顺序一致
         *  2、LinkedHashSet 底层是LInkedHashMap（是HashMap的子类）
         *  3、LinkedHashSet 底底层结构是（数组table+双向列表 即Entry类型）
         *  4、第一次添加时直接将数组 table 扩容到 16个
         *      存放的结点类型不再是Node类型，而是LinkedHashMap$Entry类型 【但是是继承自HashMap的Node类】
         *      数组类型是：HashMap$Node  结点类型是：LinkedHashMap$Entry 【父子关系】 【外部类$静态内部类】
         */
    }
}
class Customer {
    private String name;
    private int no;

    public Customer(String name, int no) {
        this.name = name;
        this.no = no;
    }
}
