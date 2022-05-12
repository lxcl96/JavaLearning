package chapter14_Collect_.Set_.TreeSet_;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet_ {
    public static void main(String[] args) {
//        TreeSet treeSet = new TreeSet();
        //2、如果想要TreeSet按照某种规则进行排序，就在初始化构造器传递一个比较器【匿名内部类】
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 == null || o2 == null) return 1;//不加就不能传递 null 【如果设置为0 就是替换不是添加了】
                String s1 = (String) o1;
                String s2 = (String) o2;
//                return s2.compareTo(s1);
                return s1.length() - s2.length(); //【弊端：长度相同的加不进去了】
            }
        });
        treeSet.add(null);
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("sp");
        treeSet.add("a");
        treeSet.add(1);
        //1、初始默认TreeSet按照首字母排序
        System.out.println(treeSet);

        /**
         * 加上比较器参数Comparator步骤 【匿名内部类】
         *   1、TreeSet(比较器) =>TreMap(比较器) =>TreeSet(NavigableMap<E,Object> m) 【调用两次TreeSet构造器】
         *   2、TreeSet.Add() => TreeMap.put()  【两者都使用了NavigableMap<K,V>接口  多态】
         *      a、第一次添加元素，调用传递的TreeMap中的compare参数和自己比
         *          传入比较器参数：使用传入的比较器进行比较 【如果在匿名内部类Comparator中传递了对null的处理操作，
         *                  可以传递null。除非做出处理，否则传递元素类型不能不一致】
         *          未传入比较器参数：调用要添加元素的比较器compareTo（如为String就用String的compareTo）
         *                  【所以默认不能传递Null，而且数据类型必须一致】
         *      b、传入比较器Comparator参数 将在TreeSet.put()喊得以下代码中对数据进行排序
         *        Comparator<? super K> cpr = comparator;//用cpr 指向自定义的比较器
         *        if (cpr != null) { //如果自定义了
         *             do {
         *                 parent = t;
         *                 cmp = cpr.compare(key, t.key); //使用自定义比较器的compare比较顺序
         *                 if (cmp < 0)   //如果返回值小于0
         *                     t = t.left;  //将当前
         *                 else if (cmp > 0) //如果返回值大于0
         *                     t = t.right;
         *                 else      ////如果返回值等于0
         *                     return t.setValue(value); //设置替换  【弊端：长度相同的加不进去了】
         *             } while (t != null);
         *         }
         *
         *      c、创立新结点
         *      Entry<K,V> e = new Entry<>(key, value, parent);
         *      d、按照上面比较位置创立新节点，然后连接起来
         *          if (cmp < 0)
         *             parent.left = e;
         *          else
         *             parent.right = e;
         */
    }
}
