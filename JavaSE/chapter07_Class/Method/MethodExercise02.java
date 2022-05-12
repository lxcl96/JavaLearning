package chapter07_Class.Method;

public class MethodExercise02 {
    /*
    克隆对象 最主要是函数返回声明 public 要返回class名 函数名（参数）{}
     */
    public static void main(String[] args) {
        //复制一个myPerson对象，返回复制的对象。
        //克隆对象要求新对象和原来的对象是两个独立的对象，只是属性相同而已
        myPerson p = new myPerson();
        p.age = 18;
        p.name = "liu yi fei";
        System.out.println(p.name + "  " + p.age);
        copy cp = new copy();
        myPerson p1 = cp.copyPerson(p);
        System.out.println(p1.name + "  " + p1.age);
        //用来验证 p和p1的name指向 不同的 常量池
        System.out.println("修改p.name=jack p.age = 99");
        p.name = "jack";
        p.age = 99;
        System.out.println("p.name = " + p.name + " p.age = " + p.age) ;
        System.out.println("p1.name = " + p1.name + " p1.age = " + p1.age) ;



    }
}
class myPerson {
    String name;
    int age;
}

class copy {
    //指明返回那个对象
    public myPerson copyPerson(myPerson p) {
        myPerson p1 = new myPerson();
        p1.age = p.age;
        p1.name = p.name;
        return p1;
    }
}
