package chapter14_Collect_.Set_.HashSet_;

public class HashSetStructure {
    public static void main(String[] args) {
        //模拟HashMap（HashSet）的底层结构   数组里存放Node链表
        /**
         * 1、创建一个数组 数据的类型为Node[]  Node数组也被叫做表
         * 2、创建结点
         */
        Node[] tables = new Node[16];
        Node john = new Node("john", null);
        tables[2] = john;
        //tables[2] => john => jack =>Rose
        Node jack = new Node("jack", null);
        john.next = jack;
        Node rose = new Node("Rose", null);
        jack.next = rose;

        Node lucy = new Node("lucy", null);
        tables[3] = lucy;


        System.out.println(tables[2]);
        System.out.println(tables[3]);

    }
}

//Node结点 形成单链表用来存放数据
class Node {
    Object item; //存放数据
    Node next;//指向下一个结点

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return "[" + item + "," + next +"]";
    }
}