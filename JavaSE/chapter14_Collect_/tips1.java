package chapter14_Collect_;

/**
 *          Iterator：迭代器
 *           1、Iterator对象称为迭代器，主要用于遍历Collection集合中的元素
 *           2、所有实现了Collection接口的集合类都有一个iterator()方法，用于返回一个实现了Iterator接口的对象
 *             即可以返回一个迭代器
 *           3、Iterator结构见图api文档
 *           4、Iterator仅用于遍历集合，Iterator本身并不存放对象
 */
public class tips1 {
//Collection
}
/*
    ● Collection接口遍历元素
        方式一：使用 Iterator（迭代器）  CollectionIterator.java
            Iterator iterator = col.iterator(); 得到一个集合迭代器
            while(iterator.hasNext()){ //hasNext()判断是否还有其余元素
                //不进行hasNext()判断会抛出 NoSuchElementException
                sout(iterator.next());//完成两个操作：1：下移一位 2：取出元素【先移后取】
            }

        方式二：使用 增强for循环，其实就是iterator迭代器的简洁版，【只能用于遍历数组或集合】
            for(元素类型 元素名：集合名或数组名) {
                元素名的元素;
            }

            for(Object obj: col) {
                sout(col)
            }
            注意：【增强for底层依然是迭代器iterator，可以debug看一下】

 */