package chapter07_Class.Method;

public class MethodDetail02 {
    public static void main(String[] args) {
        // 传值不变，传址会变
        //*** 即基本数据类型不会变，
        // *** 引用数据类型会变 {数组，字符串，对象/类}
        Test myTest = new Test();
        Person p = new Person();
        //引用对象常量 也是在在堆中  所以传递的是地址
        p.age = 10;
        p.name = "jack";
        myTest.test200(p);
        System.out.println(p.age);
        System.out.println(p.name);
    }
}

class Person {
    String name;
    int age;
}
class Test {
    public void test200(Person p) {
        p = new Person();
        p.name = "Tom";
        p.age = 99;
//        p = null;
//        p.age = 10000;
    }
}