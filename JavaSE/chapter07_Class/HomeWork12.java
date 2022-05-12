package chapter07_Class;

public class HomeWork12 {
    public static void main(String[] args) {

    }
}
//复用构造器 在构造器中使用 另一个构造器 this()
class employee {
    String name;
    char sex;
    int age;
    String job;
    double sal;

    public employee(String job, double sal) {
        this.job = job;
        this.sal = sal;
    }
    public employee(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    //复用构造期
    public employee(String name, char sex, int age, String job, double sal) {
        this(name, sex, age); //employee(String name, char sex, int age) 构造器复用必须放在第一条
//        this(job, sal); //没办法复用了
        this.job = job;
        this.sal = sal;
    }

}