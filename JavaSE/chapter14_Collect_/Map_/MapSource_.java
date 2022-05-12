package chapter14_Collect_.Map_;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSource_ {
    public static void main(String[] args) {
        //EntrySet解读
        //1、k-v最后存放的是   HashMap$Node table[i] = newNode(hash, key, value, null);
                //EntrySet是内部类，entrySet是集合，entrySet()是方法
        //2、为了方便程序员遍历【包含全部k-v】，还会创建一个entrySet集合，
        //      该集合entrySet里面存放的元素类型就是Entry【接口Map的接口】，而一个Entry里面就包含key，value
        //       形式如：EntrySet<Entry1<k1,v1>,Entry2<k2,v2>> 即transient Set<Map.Entry<K,V>> entrySet;
        //3、entrySet中定义的类型是 Map.Entry，
        //  但是实际存放的还是 HashMap$Node 【因为HashMap$Node 使用了（implements） Map.Entry接口，相当于继承（接口多态）】
        //【把HashMap$Node存放在EntrySet的根本原因就是为遍历方便】
        //当把HashMap$Node放在entrySet集合中，我们就可以使用Map.Entry接口的getkey()和getvalue()方法了
        Map map = new HashMap();
        map.put("no1", "hsp");
        map.put("no3",1);

        Set set = map.entrySet();
        System.out.println(set);
        System.out.println(set.getClass()); //HashMap$EntrySet

        for (Object obj:set) {//set集合里面的元素类型封装是Entry类型【向上转型，Map.Entry接口】，但底层是Node[]类型的
//            System.out.println(obj.getClass());//HashMap$Node
            //将Object向下转型成Map.Entry，使用getkey()和getvalue()方法
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-" + entry.getValue());
            System.out.println("[" + entry.getKey().hashCode() + "-" + entry.getValue().hashCode() + "]");

        }

        /**
         * 总结： 【set集合 具体类型自定，针对本文中是HashMap$Node 需要封装成Map.Entry来使用一些特殊方法】
         *  Table表【数组+链表】里面存放的是HashMap$Node类型，为了方便遍历 建立了一个entrySet集合存放Table表里的值
         *      entrySet里面存放的数据类型是Entry类型【Map.Entry接口】 而一个Entry类型里又有key-value
         *      其中全有key组成的集合叫 keySet()  【可看api文档】
         *      其中全有value组成的集合叫 values()
         *      EntrySet<Entry1<k1,v1>,Entry2<k2,v2>> 【Entry类型实际上就是HashMap$Node类型，只是封装成Entry】
         *///Entry1<k1,v1> 是作者为方便设计，实际存放类型是HashMap$Node
        //HashMap$Node 使用了Map.Entry接口  所以Map.Entry可以指向HashMap$Node
    }
}
