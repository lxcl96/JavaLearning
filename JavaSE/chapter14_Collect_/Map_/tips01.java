package chapter14_Collect_.Map_;

public class tips01 {
}
/**
 * Map遍历： MapFOr.java
 *   1：遍历出所有的key，再通过key取出value 【Set set = map.keySet();】
 *      1.1: 因为是set可以用 iterator迭代器
 *      1.2: 因为是set可以用 增强For循环
 *   2：遍历出所有的value  【Collection values = map.values();】
 *      2.1: 因为是set可以用 iterator迭代器
 *      2.2: 因为是set可以用 增强For循环
 *
 *   3：使用entrySet遍历  元素类型是Entry可以向下转写成HashMap$Node
 *      3.1: 因为是set可以用 iterator迭代器
 *      3.2: 因为是set可以用 增强For循环
 *
 *
 */