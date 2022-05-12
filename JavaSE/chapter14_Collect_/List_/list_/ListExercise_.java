package chapter14_Collect_.List_.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExercise_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add("hello " + i);
        }
        list.add(1, "hsp");
        System.out.println(list);
        System.out.println(list.get(4));
        list.remove(5);
        System.out.println(list);
        list.set(6, "haha");
        System.out.println(list);

        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println(obj);
        }
    }
}
