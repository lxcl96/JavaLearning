package chapter07_Class.This;

public class This01 {
    public static void main(String[] args) {
        Dog d1 = new Dog("阿黄", 5);
        d1.info();
        System.out.println("d1.hashCode() = " + d1.hashCode());
    }
}
/*
    java虚拟机会给每个对象分配一个this，代表当前对象
    this.name = name; 其中 this.name表示对象的 属性 name表示方法的形参
    可以简单记住this就是实例化的类，表示自己
    主要是用来区分 当前类的属性和局部变量
 */
class Dog{
    int age;
    String name;
    //构造器
    Dog(String name, int age){
        //可不可以直接写出 name = name;age = age呢？
        //不行的 变量遵循就近原则，如果使用上面的方法则 name和age就由 类属性 变成了局部变量
        //那怎么解决这个问题呢？ this
        this.name = name;
        this.age = age;
    } //重载
    public void info() {
        System.out.println("name = " + this.name + " age = " + age + "      地址：" + this.hashCode());
    }
}
