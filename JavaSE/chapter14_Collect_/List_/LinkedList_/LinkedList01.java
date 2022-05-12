package chapter14_Collect_.List_.LinkedList_;

public class LinkedList01 {
    public static void main(String[] args) {
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node hsp = new Node("hsp");
        //连接三个结点  形成双向链表【不是循环双向链表】
        jack.next = tom;
        tom.next = hsp;  // jack <=> tom <=> hsp
        tom.pre = jack;
        hsp.pre = tom;
        //建立 头尾结点
        Node first = jack;
        Node last = hsp;

        //双向链表的好处就是增删 元素特别方便
        //在tom和hsp中间插入一个 mary
        Node mary = new Node("mary");// jack <=> tom <=> mary<=> hsp
        tom.next = mary;
        mary.next = hsp;
        hsp.pre = mary;
        mary.pre = tom;
        //顺序输出
        while (true) {
            if (first == null)
                break;
            System.out.println(first);
            first = first.next;
        }

        //逆序输出
        while (true) {
            if (last == null)
                break;
            System.out.println(last);
            last = last.pre;
        }

    }
}

//定义一个Node类，Node对象表示双向链表的一个节点
class Node {
    public Object item;//真正存放数据
    public Node next;//指向后一个结点
    public Node pre;//指向前一个结点

    public Node(Object name) {
        this.item = name;
    }

    @Override
    public String toString() {
        return "Node name = " + item;
    }
}