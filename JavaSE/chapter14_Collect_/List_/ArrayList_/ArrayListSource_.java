package chapter14_Collect_.List_.ArrayList_;

import java.util.ArrayList;

public class ArrayListSource_ {
    public static void main(String[] args) {
        //无参构造器 扩容 1、容量数组为0 2、第一次添加元素为10 3、以后每次再次扩容时扩都是：原来的个数*1.5
        ArrayList list = new ArrayList();
        for (int i = 1; i <= 10 ; i++) {
            list.add(i);
        }
        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }
        //debug默认显示不全，可以在Settings -> Debugger -> Data Views -> Java
        //      -> enabled alternative view of Collections classes 不勾选
        list.add(100);
        list.add(200);
        list.add(null);

        //有参构造器 扩容 1、先创建数组个数为 参数的 2、再次扩容 就为 原来的个数*1.5
        //其中参数为1 特殊每次都是 1 错了 就第一次为1 后面都是 1 2 3 4 6 . 。 。
        ArrayList list1 = new ArrayList(0);
        list1.add(111);

    }
}
