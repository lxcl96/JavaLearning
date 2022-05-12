package chapter14_Collect_.CollectionsToolClass_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* Collections工具类*/
public class CollectionsTool {
    public static void main(String[] args) {
        //Collections
        ArrayList arrayList = new ArrayList();
        arrayList.add("tom");
        arrayList.add("smith");
        arrayList.add("king");
        arrayList.add("milan");
        System.out.println(arrayList);
        //reverse反转
        Collections.reverse(arrayList);
        System.out.println(arrayList);
        //shuffle随机排序
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
        //sort 首字母升序
        Collections.sort(arrayList);
        System.out.println("首字母升序" + arrayList);
        //sort 传递比较器 逆首字母序排序
        Collections.sort(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o2).compareTo((String) o1);
            }
        });
        System.out.println(arrayList);

        Collections.swap(arrayList, 0, 2);
        System.out.println(arrayList);
        //max 根据首字母大小排序给出最大的一个
        System.out.println(Collections.max(arrayList));
        //min 根据首字母大小排序给出最小的一个
        System.out.println(Collections.min(arrayList));

        //max(List, Comparator)指定大小规则 比如长度
        System.out.println(Collections.max(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o2).length() - ((String)o1).length();
            }
        }));
        //min(List, Comparator)同理

        //int frequency(List, Object)返回集合中元素出现的次数
        System.out.println("tom出现了：" + Collections.frequency(arrayList, "tom"));

        //copy(src, des)从src复制到des  新数组需要先指定大小 des.length >= src.length
        //replaceAll（List，old， new）用new替换old
    }
}
