package chapter14_Collect_;

import java.util.ArrayList;
import java.util.List;

/* 以Collect-List——ArrayList为例 */
public class CollectionMethod {
    public static void main(String[] args) {
        //向上转型
        List list = new ArrayList();
        list.add("hello");//参数是object，因此之药时Object子类都可以
        list.add(1);//有个自动装箱的操作  实际上是list.add(new Integer(1))
        list.add(1.0);
        list.add('1');
        list.add(true);
        System.out.println(list.size());
        Boolean b = list.remove("hello");//返回Boolean值
        Object e = list.remove(1);
        System.out.println(list);
        System.out.println(e);
        List list2 = new ArrayList();
        list2.add("list2=");
        list2.addAll(list);//ArrayList中添加另一个ArrayList
        list2.add(",over");
        System.out.println(list2);
        System.out.println(list2.containsAll(list2));//全部包含
        System.out.println(list2.containsAll(list));//全部包含
        System.out.println(list2.contains(list));//全部包含
        System.out.println(list2.contains(1));//全部包含
        list2.removeAll(list);//ArrayList中删除另一个ArrayList
        System.out.println(list2);

    }
}
