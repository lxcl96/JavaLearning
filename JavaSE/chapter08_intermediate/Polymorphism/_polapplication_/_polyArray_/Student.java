package chapter08_intermediate.Polymorphism._polapplication_._polyArray_;

public class Student extends Person {
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String say() {
//        return this.getName() + this.getAge() + this.getScore();
        return super.say() + this.getScore();//还可以这样
    }

    public void study() {
        System.out.println("学生" + super.getName() + "在上课。。。");
    }
}
