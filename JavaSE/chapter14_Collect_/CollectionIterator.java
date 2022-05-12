package chapter14_Collect_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古老", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));
        System.out.println(col);

        //使用iterator进行迭代访问 [都需要Book类的toString方法]
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) { //快捷建 itit 查看所有的快捷键Ctrl + j
//            Object obj = iterator.next();//返回一个Object对象
            System.out.println(iterator.next());
        }
        //会报异常 iterator 已经指向最后一个元素了，没有重置位置 可以使用iterator = col.iterator();重置
        iterator = col.iterator();
        System.out.println(iterator.next());
        System.out.println("==使用增强for循环进行遍历==");
        for (Object obj1: col) {
            System.out.println(obj1);
        }
    }
}

class Book {
    private String bookName;
    private String author;
    private double price;

    public Book(String bookName, String author, double price) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[ " + bookName + "," + author + "," + price + "]";
    }
}