package chapter14_Collect_.Set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMethod_ {
    public static void main(String[] args) {
        //以hashset为例演示 Set方法
        /**
         * 1、set接口的实现类的对象（Set接口对象），不能存放重复元素 可以添加一个null
         * 2、set接口对象是无序的【但是每次输出都是一样的不会改变】
         */
        Set set = new HashSet();
        set.add("john");
        set.add("lucy");
        set.add("john");//不会报错，但是也不会重复
        set.add("jack");
        set.add(null);
        set.add(null);//不会报错，但是也不会重复

        System.out.println(set);
        //Collection
        //遍历 方式一 迭代器iterator
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

        //遍历 方式二 增强for循环
        for (Object obj:set) {
            System.out.println(obj);
        }

    }
}
