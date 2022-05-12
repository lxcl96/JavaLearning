package chapter07_Class.Scope;

public class Scope {
    public static void main(String[] args) {
        scopeExamle s = new scopeExamle();
        s.f3();
    }
}

class scopeExamle {
    /*
    类中全局变量可以不初始化使用
    但是 局部变量必须要初始化后才能使用；

     */
    int age = 10; //在类scope中 age为全局变量
    public int age2;
    {
        char sex = '男'; //{} 代码块中 也为局部变量
    }
    public void f1() {
        String name = "lihua"; //name为局部变量
    }
    public void f2() {
        System.out.println(age); //打印全局变量 没问题
//        System.out.println(sex);//打印代码块 局部变量照不到
//        System.out.println(name);//打印方法 局部变量照不到
        int age3;
        System.out.println("age2 = " + age2);
//        System.out.println("age3 = " + age3);//就会出错

    }

    public void f3() {
        //局部变量可以和全局变量重复
        //变量使用时遵循就近原则 即 优先用最近的那个
        int age = 11;
        System.out.println("age = " + age);
    }

    public void f4() {
        //在同一作用域 比如同一方法中 变量名不能重复
        char color = '红';
//        int color = 100;
    }

    public void f5() {
        //局部变量不可以加修饰符 ，全局变量可以
//       private char color = '红';
    }
}