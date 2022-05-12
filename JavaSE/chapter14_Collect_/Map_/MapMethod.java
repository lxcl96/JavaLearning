package chapter14_Collect_.Map_;

import java.util.HashMap;
import java.util.Map;

public class MapMethod {
    public static void main(String[] args) {
        Map map = new HashMap();
        //put添加
        map.put("邓超", new Book("", 100));
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋喆", "马蓉");
        map.put("刘凌博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");
        System.out.println(map);
        //get(key) -> values
        Object object = map.get("邓超");
        System.out.println(object);//key重复就会被最新的替换 --孙俪
        //containsKey() 是否有指定key
        System.out.println(map.containsKey("王宝强"));
        //containsValue() 是否有指定value
        System.out.println(map.containsValue("马蓉"));
        //不存在映射关系k-v，或说map为空
        System.out.println(map.isEmpty());
        //remove(key) 如果有key删除k-v 返回values
        System.out.println(map.remove("王宝强"));

        //clear 清空所有键值对
        map.clear();
        //size() 返回键值对个数
        System.out.println(map.size());//6
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }
}