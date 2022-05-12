package chapter08_intermediate.Polymorphism.detail_;

public class PolyDetail02 {
    public static void main(String[] args) {
        //向上转型
        Base base = new Sub();
        System.out.println(base.account);//输出10  因为属性没办法重新写
        //instanceOf 比较操作符 用来判断对象的类型是否为xx类型或xx类型的子类型
    }
}
//属性没办法重写
class Base {
    int account = 10;
}

class Sub extends Base {
    int account = 20;
}
