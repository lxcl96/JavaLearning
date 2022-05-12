package chapter14_Collect_.List_.LinkedList_;

import java.util.LinkedList;

public class LinkedListUse {
    public static void main(String[] args) {
        //源码解读 debug
        LinkedList list = new LinkedList();
        /**
         * 增加新结点步骤：
         *   1、先判断是不是基本数据类型，如果是先进行装箱
         *   2、进入add内部，调用linkLast方法，参数是要添加的元素
         *   3、正式添加元素
         *          a、新建指针 l 保存当前 last指针（后面用来判断是不是第一次添加）
         *          b、使用要添加的元素创建新结点 构造器 Node(Node<E> prev, E element, Node<E> next) 传入参数 pre ，要添加的元素，下一个结点（如果没有就为空）
         *              。每次都传入上一个结点其实就是last，也就是l
         *              。 新结点连起来（next指向null，pre指向l，赋值）
         *   4、添加万元素，更新last指针即后移一位 last = newNode【刚才建立的新结点】
         *          此时新结点的前后指针均已经连好，但是l代表的上一个结点的next没有连接上
         *   5、l.next = newNode 【或者：first = newNode 仅在第一次添加元素时使用】
         *      但是如果l是null结点呢？即刚才的newNode是第一个结点，那么就需要建立头节点，【每次更新只更新last，但是第一次要更新first】
         */
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }


    }
}
