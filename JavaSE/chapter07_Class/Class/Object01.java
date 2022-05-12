package chapter07_Class.Class;

public class Object01 {
    public static void main(String[] args) {

        //实例化/创建一只猫
        //String 为引用类型 会放在方法区的常量池里
        Cat cat1 = new Cat(); //属性 = 成员变量 = field（字段）
        cat1.name = "小花";
        cat1.age = 3;
        cat1.color = "白色";

        Cat cat2 = new Cat();
        cat2.name = "大咪";
        cat2.age = 100;
        cat2.color = "花色";

        System.out.println(cat1.name + " " + cat1.age + " " + cat1.color);
    }
}
//类可以写在外面
class Cat {
    String name;
    int age;
    String color;
}
