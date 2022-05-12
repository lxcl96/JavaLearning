package chapter07_Class;

public class HomeWork03 {
    public static void main(String[] args) {
        Book b1 = new Book("鲁滨逊漂流记", 55);
        Book b2 = new Book("算法", 250);
        Book b3 = new Book("菜谱大全", 150);
        System.out.println(b1.name + " " + b1.price);
        System.out.println(b2.name + " " + b2.price);
        System.out.println(b3.name + " " + b3.price);
        b1.updatePrice();
        b2.updatePrice();
        b3.updatePrice();
        System.out.println(b1.name + " " + b1.price);
        System.out.println(b2.name + " " + b2.price);
        System.out.println(b3.name + " " + b3.price);

    }
}
//实现更改某本书的价格，具体：如果价格>150则改为150，如果价格>100 更改为100 否则不变
class Book {
    double price;
    String name;
    public Book(String name, double price) {
        this.price = price;
        this.name = name;
    }

    public void updatePrice() {
        if (this.price > 150)
            this.price = 150;
        else if (this.price > 100)
            this.price = 100;
    }
}
