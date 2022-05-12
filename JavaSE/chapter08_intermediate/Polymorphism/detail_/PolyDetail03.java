package chapter08_intermediate.Polymorphism.detail_;

public class PolyDetail03 {
    public static void main(String[] args) {
//        AA aa = new AA();
        BB bb = new BB();
        // A instanceOf B 比较操作符 用来判断对象A的运行类型是否为B类型 或B类型的子类型 【运行类型】
        System.out.println(bb instanceof BB);
        System.out.println(bb instanceof AA);
//        System.out.println(aa instanceof AA);
//        System.out.println(aa instanceof BB);

        // instanceOf 比较的是运行类型
        AA aa = new BB();
        System.out.println(aa instanceof BB);//true
        System.out.println(aa instanceof AA);//true  BB是A的子类

    }
}

// A instanceOf B 比较操作符 用来判断对象A的类型是否为B类型 或B类型的子类型
class AA{
}
class BB extends AA {}