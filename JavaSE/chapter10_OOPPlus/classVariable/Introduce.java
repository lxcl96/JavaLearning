package chapter10_OOPPlus.classVariable;

public class Introduce {
    public static void main(String[] args) {
        Child c1 = new Child("白骨精");
        c1.join();
        c1.count2++;
        c1.count1++;
        Child c2 = new Child("狐狸精");
        c2.join();
        c2.count2++;
        c2.count1++;
        Child c3 = new Child("老鼠精");
        c3.join();
        c3.count2++;
        c3.count1++;
        System.out.println("c1.count1=" + c1.count1);//类变量公用 3
        System.out.println("c1.count2=" + c1.count2);//属性私用  1
        System.out.println("c2.count1=" + c2.count1);
        System.out.println("c2.count2=" + c2.count2);
        System.out.println("c3.count1=" + c3.count1);
        System.out.println("c3.count2=" + c3.count2);
        //类变量可以通过类名来访问 c1.count1 = c2.count1 = c3.count1 = Child.count1
        System.out.println("Child.count1=" + Child.count1);
    }
}
/*
    记住类中 static变量就是类变量，就被同一个类的所有对象共享的
    static变量（类变量） 在类加载时就生成了

 */
class Child {
    //体会这两个区别
    //count1公共属性  若干个类公用一个存储空间 加上static 就是类变量
    public static int count1 = 0;
    public int count2 = 0;
    private String name;

    //构造期都选不到count1
    public Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println(this.name + " 加入了游戏。");
    }
}