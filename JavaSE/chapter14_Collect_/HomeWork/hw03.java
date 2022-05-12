package chapter14_Collect_.HomeWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class hw03 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("jack", 650);
        map.put("tom", 1200);
        map.put("smith", 2900);
        System.out.println(map);
        map.put("jack", 2600);//不能重复
        System.out.println(map);

        Set sets = map.entrySet();
        for (Object set : sets) {
            map.put(((Map.Entry)set).getKey(), (int)(((Map.Entry)set).getValue()) + 100);
        }
        System.out.println(map);

        Set set = map.keySet();
        for (Object o : set) {
            System.out.println(o + ":" + map.get(o));
        }


    }
}
