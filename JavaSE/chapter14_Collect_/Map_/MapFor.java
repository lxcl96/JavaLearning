package chapter14_Collect_.Map_;

import java.util.*;

public class MapFor {
    public static void main(String[] args) {
        //Map接口的遍历方式
        Map map = new HashMap();
        map.put("邓超", new Book("", 100));
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋喆", "马蓉");
        map.put("刘凌博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");
        System.out.println(map);
        //方法1：遍历出所有的key，再通过key取出value
        Set set = map.keySet();//set集合；两种遍历 iterator迭代器和增强For循环
        //1.1：iterator迭代器
        System.out.println("-----------方法1.1 迭代器遍历--------------");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next + ":" + map.get(next));//无法转成EHash$Node类型，因为是Set而不是Entry类型
        }
        //1.2：增强For循环
        System.out.println("-----------方法1.2 增强For循环--------------");
        for (Object o:set) {
            System.out.println(o + ":" + map.get(o));//无法转成EHash$Node类型，因为是Set而不是Entry类型
        }

        //方法2：遍历出所有的value
        Collection values = map.values();
        //2.1：iterator迭代器
        System.out.println("-----------方法2.1 迭代器遍历--------------");
        Iterator it = values.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            System.out.println(next);//无法转成EHash$Node类型，因为是Set而不是Entry类型
        }
        //2.2：增强For循环
        System.out.println("-----------方法2.2 增强For循环--------------");
        for (Object o:values) {
            System.out.println(o);//无法转成EHash$Node类型，因为是Set而不是Entry类型
        }
        /**
         * set是集合，里面的数据类型不一定，反正不是set针对本文中方法三 set1是 HashMap$Node类型
         *      集合中存的就是HashMap$Node类型，需要开发者自己 向下转型 成Map.Entry来使用相应方法
         *      Object 转 Entry向下转型 【下面返回的是Object 所以是向下】
         *      HashMap$Node 转 Entry 向上转型
         */
        //方法3：使用entrySet遍历  元素类型是Entry可以向下转写成HashMap$Node
        Set set1 = map.entrySet();
        //3.1：iterator迭代器
        Iterator iterator1 = set1.iterator();
        System.out.println("-----------方法3.1 迭代器遍历--------------");
        while (iterator1.hasNext()) {
            Object c = iterator1.next();
            System.out.println(c.getClass());//此处iterator1.next()就是HashMap$Node类型
            Map.Entry next =  (Map.Entry)c;//直接去有等号，隔开取【此处iterator1.next()就是HashMap$Node类型】
            System.out.println(next.getKey() + ":" + next.getValue());
        }
        //3.2 增强For循环
        System.out.println("-----------方法2.2 增强For循环--------------");
        for (Object o:set1) {
            System.out.println(o.getClass());//此处iterator1.next()就是HashMap$Node类型
            Map.Entry entry = (Map.Entry)o;
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}
