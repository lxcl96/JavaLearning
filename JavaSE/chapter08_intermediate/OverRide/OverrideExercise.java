package chapter08_intermediate.OverRide;

public class OverrideExercise {
    public static void main(String[] args) {
        Person person = new Person("tom", 22);
        System.out.println(person.say());

        Student student = new Student("jerry", 20, 001, 100);
        System.out.println(student.say());;
    }
}

class Person {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String say() { return "大家好，我叫" + this.name + "今年" + this.age + "岁。";}
}

class Student extends Person {
    private int id;
    private double score;

    public Student() {
    }

    public Student(String name, int age, int id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public String say() {
        super.say();
        return super.say() + "id是" + this.id + "，成绩是" + this.score;//可以这样返回
    }
}
