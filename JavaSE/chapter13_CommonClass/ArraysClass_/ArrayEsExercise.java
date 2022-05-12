package chapter13_CommonClass.ArraysClass_;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayEsExercise {
    //按照价格,书名排序
    public static void bubble2(Book[] arr, Comparator c) {
        Book tmp = null;
        for (int i = 0; i < arr.length -1 ; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }

        }
    }

    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦~", 100);
        books[1] = new Book("金瓶梅~", 90);
        books[2] = new Book("青年文摘~", 5);
        books[3] = new Book("java从入门到放弃~", 300);

        System.out.println(Arrays.toString(books));

        //使用自己的方法
        System.out.println("价格从大到小:");
        bubble2(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book)o1;
                Book b2 = (Book)o2;
                return b2.getPrice() - b1.getPrice();
            }
        });
        System.out.println(Arrays.toString(books));

        //使用系统的 Arrays.sort方法
        System.out.println("价格从小到大:");
//        bubble2(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book b1 = (Book)o1;
//                Book b2 = (Book)o2;
//                return b1.getPrice() - b2.getPrice();
//            }
//        });
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book)o1;
                Book b2 = (Book)o2;
                return b1.getPrice() - b2.getPrice();
            }
        });
        System.out.println(Arrays.toString(books));


        //使用系统的 Arrays.sort方法
        System.out.println("书名从大到小排序:");
//        bubble2(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book b1 = (Book)o1;
//                Book b2 = (Book)o2;
//                return b2.getName().length() - b1.getName().length();
//            }
//        });
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book)o1;
                Book b2 = (Book)o2;
                return b2.getName().length() - b1.getName().length();
            }
        });
        System.out.println(Arrays.toString(books));

    }
}
class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "[" + name + "," + price + ']';
    }
}
