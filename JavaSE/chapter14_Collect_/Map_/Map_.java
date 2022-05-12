package chapter14_Collect_.Map_;

import java.util.HashMap;
import java.util.Map;

public class Map_ {
    public static void main(String[] args) {
        //Map接口实现类的特点   以HashMap为例
        Map map = new HashMap();
        map.put("no1", "hsp");
        map.put("no1", "ly");//key重复 后面的value会替换前面一个
        map.put(map, "ly");//value可以重复
        map.put("no3",null);
        map.put(null,null);
        map.put(null,123);//替换了
        map.put("no4",null);
        System.out.println(map);
        System.out.println(map.entrySet());
        System.out.println(map.keySet());

        System.out.println(map.get(""));//通过key取value,如果没找到返回null
        System.out.println(map.get(null));//通过key取value
        System.out.println(map.isEmpty());//判断一个HashMap对象是否存在数据，或者是否为空
    }
}
