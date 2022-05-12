package chapter07_Class;

public class HomeWork08 {
    public static void main(String[] args) {
        //匿名对象 没有返回 只能用一次new test()时也会创建count = 9
        new test().count1();

        test t1 = new test();
        t1.count2();
        t1.count2();

    }
}

class test {
    int count = 9;
    public void  count1() {
        count = 10;
        System.out.println("count1=" + count);
    }
    public void  count2() {
        System.out.println("count1=" + count++);
    }
}
