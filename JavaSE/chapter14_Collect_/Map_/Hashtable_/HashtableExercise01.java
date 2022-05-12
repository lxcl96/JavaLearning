package chapter14_Collect_.Map_.Hashtable_;

import java.util.Hashtable;

public class HashtableExercise01 {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        //hashtable.put(null, "hah");//空指针异常
        //hashtable.put("haha", null);//空指针异常
        hashtable.put("haha", "null");
        hashtable.put("haha", "haha");
        System.out.println(hashtable);

        /**
         * Hashtable底层：
         *   1、底层由一个数组 Hashtable$Entry 初始化大小为11
         *   2、threshold初始化为 8=(int)11*0.75
         */

    }
}
