package chapter14_Collect_.List_.list_;

import java.util.ArrayList;
import java.util.List;

public class ListExercise02 {
    //接受集合类
    public static void Bubble(List list) {
        Book tmp = null;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                Book b1 = (Book) list.get(j);
                Book b2 = (Book) list.get(j + 1);
                if (b1.getPrice() > b2.getPrice()) {
                    tmp = b1;//这样只交换了b1b2 没有更改list集合
                    list.set(j, b2);//b1 = b2
                    list.set(j + 1, tmp);//b2 = tmp
                }
            }
        }

    }
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("水浒传", "施耐庵", 9));
        list.add(new Book("三国演义", "罗贯中", 80));
        list.add(new Book("西游记", "吴承恩", 10));

        System.out.println(list);
        Bubble(list);
        System.out.println(list);

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
        return "[名称：" + bookName + "\t"
                + "价格：" + price + "\t"
                + "作者：" + author + "]";
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}
