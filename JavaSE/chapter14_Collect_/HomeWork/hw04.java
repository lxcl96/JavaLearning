package chapter14_Collect_.HomeWork;

public class hw04 {
}
/*
    问：试分析HashSet和TreeSet如何实现去重的
      HashSet的底层其实就是HashMap，HashMap在进行数据存储时需要计算key的hash值来指定存放位置【数组】。因为HashSet只存储
    Key所以每次比较都需要比较key的hash值和key的元素值如果比较发现只要这两个均成立则认为HashSet中已经纯在相同的key了。实现key值去重

      treeSet的底层是TreeMap，是通过穿入的Comparator比较器进行去重的


      hsp答案:
      （1） HashSet的去重机制: hashCode() + equals()【可以自定义比较规则】 ,底层先通过存入对象,进行运算得到一个hash值，通过hash值得到
      对应的索引，如果发现table索引所在的位置,没有数据，就直接存放,如果有数据，就进行equals比较[遍历比较]，如果比较后，不相同,就加入，否则就不加入.


      (2) TreeSet的去重机制:如果你传入了一个Comparator匿名对象，就使用实现的compare去重，如果方法返回0,就认为是相同的元素/数据，就不添加，
         如果你没有传入一个Comparator匿名对象，则以你添加的对象实现的Compareable接口的compareTo去重.


 */