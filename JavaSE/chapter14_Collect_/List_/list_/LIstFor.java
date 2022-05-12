package chapter14_Collect_.List_.list_;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class LIstFor {
    public static void main(String[] args) {
//        List list = new ArrayList();
//        List list = new LinkedList();  //这三种完全通用
        List list = new Vector();
        list.add("haha");
        list.add("you");
        list.add("are");
        list.add("cool");
        System.out.println(list);
        //方式一、迭代器遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        //方式二、增强for循环
        for(Object obj:list) {
            System.out.println(obj);
        }

        //方式三、普通for循环
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
}
