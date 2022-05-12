package chapter14_Collect_.List_.list_;

public class tips {
}
/*
    ● List接口 【包含Vector、ArrayList、LinkedList】
      List'接口是Collection接口的子接口 List_.java
      1、List集合类中元素都是有序的（即：添加顺序和取出顺序一致）、且可重复
      2、List集合中的每个元素都有其对应的顺序索引，即支持索引。
      3、List容器/集合 中的元素都对应一个整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素

    ● ArrayList注意事项： ArrayListDetail.java
      1、ArrayList可以存放所有的数据元素，甚至是空元素null,可以重复多个
      2、ArrayList是由数组来实现数据存储的
      3、ArrayList基本等同于Vector，除了ArrayList是多线程不安全（但是执行效率高）【同StringBuilder】，所以在多线程情况下不要使用ArrayList


 */