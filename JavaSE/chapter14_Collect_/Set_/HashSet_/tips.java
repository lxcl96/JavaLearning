package chapter14_Collect_.Set_.HashSet_;

public class tips {
}
/*
    HashSet说明：【HashSet实际上是HashMap，而HashMap的底层是：数组+链表+红黑树】 简单模拟底层：HashSetStructure.java
      1、HashSet实现了Set接口
      2、HashSet实际上是HashMap，看下源码（图）
            public HashSet() {
                map = new HashMap<>();
            }
      3、可以存放null值，但是只能存放一个
      4、HashSet不保证元素是有序的，取决于hash后，在确定索引的结果
      5、不能有重复的元素/或对象 【地址相同的，地址不同但是内容相同的可以 String特殊】   底层源码：HashSetSource.java
 */