package chapter14_Collect_.Set_.HashSet_;

import java.util.HashSet;

public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println(hashSet);

        /*
          源码解读：
           1、使用构造器初始化 map = new HashMap<>();
           2、使用add方法  此时参数仍然是 字符串常量非hash值
           3、执行put(K key, V value)方法  //value没啥用，因为它是static final类型 一直不会变化
               a、计算参数的hash值
               b、执行putVal(hash(key), key, value, false, true)
               c、putVal源码如下
               <!------------------------------------------------------------------------------!>
               final V putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict) {
                    Node<K,V>[] tab; Node<K,V> p; int n, i;
                    if ((tab = table) == null || (n = tab.length) == 0) //这个table就是前面讲的 Node[]用于存放链表，HashMap的属性初始为空
                        n = (tab = resize()).length; //在此处重新计算大小，包括初始化table Node数组大小为16 ，设置阈值12当使用量达到12时自动扩容（16+）

                    if ((p = tab[i = (n - 1) & hash]) == null) //此处执行按位与操作，如3254803 和16-1=15 的二进制进行与操作【15转成二进制前面不足位补0】
                                                                        //得 出结果为3表示table数组（Node[]）中的序号
                                                                            //同时判断序号为3位置上有没有元素，如果没有直接添加
                        tab[i] = newNode(hash, key, value, null); //序号为3位置上没有元素，直接添加
                    else {
                        Node<K,V> e; K k;
                        if (p.hash == hash &&  //p表示第一次添加的java ，hash表示本次要添加java的hash
                            ((k = p.key) == key || (key != null && key.equals(k))))  //判断地址是否相同或者值是否相同【可以自己设计的，此处仅用String说明】，所以String就被pass掉了，而Dog类型的地址不同结果就是true||false=true通过
                            e = p; //标记头节点
                        else if (p instanceof TreeNode)  //判断是否已经转化为树节点了
                            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                        else {              //链表循环比较
                            for (int binCount = 0; ; ++binCount) {
                                if ((e = p.next) == null) {
                                    p.next = newNode(hash, key, value, null);
                                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st  //如果链表长度达到了8个，进行树化
                                        treeifyBin(tab, hash);//函数里又会进行比较，看看数组是不是达到64位；如果还没有达到64位就会进行扩容，如果已经达到了64位就会红黑树化  resize()函数就是进行扩容
                                    break;
                                }
                                if (e.hash == hash &&
                                    ((k = e.key) == key || (key != null && key.equals(k))))
                                    break;
                                p = e;
                            }
                        }
                        if (e != null) { // existing mapping for key 如果头结点不为空
                            V oldValue = e.value; //保存下头节点的 HashSet中的PRESENT 空Object数组
                            if (!onlyIfAbsent || oldValue == null)  //onlyIfAbsent默认就是false
                                e.value = value; //更新HashSet中的PRESENT 空Object数组 【不知道有什么用】
                            afterNodeAccess(e);
                            return oldValue;//返回 HashSet中的PRESENT 空Object数组 【PRESENT作用：在add函数中和null比较，如果成功添加返回null然后add返回true；
                                                                                        如果添加失败返回PRESENT 空Object数组，然后add返回false】
                        }
                    }
                    ++modCount;
                    if (++size > threshold)  //判断是否需要扩容 未扩容之前threshold为12 【size是指总的挂载个数，包含table数组和链表上的，可以理解为第13次一定扩】
                        resize();
                    afterNodeInsertion(evict);//给LinkedHashmap使用的，此处为空方法
                    return null;
                }
              <!------------------------------------------------------------------------------!>
           4、

         */
    }
}
