package chapter14_Collect_.List_.Vector_;

import java.util.Vector;

public class Vector_ {
    public static void main(String[] args) {
        //有参构造器默认为 capacityIncrement=0 除非特别指定
        //  即由一个两个参数构造器用来指定扩容机制【每次扩容的个数】
        Vector vector = new Vector(2);
        vector.add(111);
        vector.add(112);
        vector.add(113);
    }
}
