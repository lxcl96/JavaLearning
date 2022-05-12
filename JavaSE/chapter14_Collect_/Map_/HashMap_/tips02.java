package chapter14_Collect_.Map_.HashMap_;

public class tips02 {
}
/**
 * HashMap小结：
 *   1、Map接口的常用实现类：HashMap[LinkedHashMap]、TreeMap、Hashtable[properties]
 *   2、HashMap是Map接口中使用频率最高实现类
 *   3、HashMap是是以key-value来存放数据的（HashMap$Node类型） 【需要自己封装成Entry来使用对应方法】
 *   4、Key不能重复，但是值可以重复、允许使用null键和null值
 *   5、如果添加相同的key，则会覆盖上一个key-value，相当于修改 保存最新一个键值对
 *   6、与HashSet一样、不保证映射后的顺序，因为底层是以hash表的方式存储的【数组+链表+红黑树】
 *   7、HashMap没有实现线程同步，因此多线程时是不安全的【没有同步互斥关建字Synchronize】
 */
