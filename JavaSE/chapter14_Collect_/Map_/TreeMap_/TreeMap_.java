package chapter14_Collect_.Map_.TreeMap_;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMap_ {
    public static void main(String[] args) {
        //TreeMap和TreeSet完全一样，只有传递参数value不是默认的PRESENT
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //return ((String)o2).compareTo((String) o1);//按照key的首字母倒叙
                return (((String)o2).length()) - (((String) o1).length());//按照key的首字母倒叙
            }
        });
        treeMap.put("jack", "杰克");
        treeMap.put("tom", "汤姆");
        treeMap.put("kristina", "克瑞斯提诺");
        treeMap.put("smith", "史密斯");

        System.out.println(treeMap);
    }
}
