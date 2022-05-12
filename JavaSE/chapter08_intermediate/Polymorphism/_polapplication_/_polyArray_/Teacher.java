package chapter08_intermediate.Polymorphism._polapplication_._polyArray_;

public class Teacher extends Person{
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String say() {
//        return this.getName() + this.getAge() + this.getSalary();
        return super.say() + this.getSalary();
    }

    public void teach() {
        System.out.println("老师" + super.getName() + "在教书。。。");
    }
}
