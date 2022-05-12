package chapter08_intermediate.Polymorphism;

public class PolyExercise02 {
    public static void main(String[] args) {
        //正常用法  访问属性看 编译类型 10  访问对象看 运行类型 20
        Sub s = new Sub();
        System.out.println(s.account);//20
        s.display();//20

        //向上转型
        Base b = s;
        System.out.println(b == s);//  true 保存的地址一样
        //访问属性看 编译类型（左边的） 10
        System.out.println(b.account); //10

        //是Sub中的display  访问属性看 编译类型（左边的） 10

        b.display();//我的答案 10 正确答案为20 【Sub中display方法自身能访问到

        /*
            我知道能调用的是 Sub中display方法 但是 认为调用不到 20  这是不对的
            其实 display是已经封装好的 方法 它自己能够访问到本类的20的  这个就是封装
            所以 最后输出的是20

         */

    }
}

class Base {
    int account = 10;
    public void display() {
        System.out.println(this.account);
    }
}

class Sub extends Base {
    int account = 20;
    public void display() {
        System.out.println(this.account);
    }
}
