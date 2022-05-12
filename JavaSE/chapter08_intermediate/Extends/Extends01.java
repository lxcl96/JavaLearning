package chapter08_intermediate.Extends;

public class Extends01 {
    public static void main(String[] args) {
        //继承
        Pupil pupil = new Pupil();
        pupil.name = "银角大王";
        pupil.age = 12;
        pupil.testing();
        pupil.setScore(60);
        pupil.showInfo();

        System.out.println("================");
        Graduate graduate = new Graduate();
        graduate.name = "金角大王";
        graduate.age = 20;
        graduate.testing();
        graduate.setScore(100);
        graduate.showInfo();


    }
}

//父类 超类 基类
class Student {

    //共有属性
    public String name;
    public int age;
    private double score;


    //共有方法
    public void setScore(double score) {
        this.score = score;
    }
    public void showInfo() {
        System.out.println("学生名：" + name + " 年龄=" + age + " 成绩=" + score);
    }
}

// 子类 派生类
//类pupil 继承自 Student
class Pupil extends Student {
    //自有属性

    //自有方法
    public void testing() {
        System.out.println("小学生" + name + "正在考小学数学...");
    }
}

// 子类 派生类
class Graduate extends Student {
    //自有属性

    //自有方法
    public void testing() {
        System.out.println("大学生" + name + "正在考高等数学...");
    }
}