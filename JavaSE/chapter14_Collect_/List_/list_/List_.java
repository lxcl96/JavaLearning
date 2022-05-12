package chapter14_Collect_.List_.list_;

import java.util.ArrayList;
import java.util.List;

public class List_ {
    public static void main(String[] args) {
        //1、List集合类中元素都是有序的（即：添加顺序和取出顺序【输出顺序】一致）、且可重复
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        list.add("tom");
        System.out.println(list);

        //2、List集合中的每个元素都有其对应的顺序索引，即支持索引。
        System.out.println(list.get(0));
    }
}

