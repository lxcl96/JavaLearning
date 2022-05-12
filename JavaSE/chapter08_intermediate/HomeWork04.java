package chapter08_intermediate;

public class HomeWork04 {
    public static void main(String[] args) {
        Normal ll = new Normal("李雷", 400, 22);
        System.out.println(ll);

        Manager hmm = new Manager("韩美美", 400, 22);
        System.out.println(hmm);

        Manager lb = new Manager("刘备", 400, 22);
        lb.setBonus(3000);
        System.out.println(lb);
    }
}
class Employee {
    private String name;
    private double daySalary;
    private int workDay;
    private double grade = 1;

    public Employee(String name, double daySalary, int workDay) {
        this.name = name;
        this.daySalary = daySalary;
        this.workDay = workDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaySalary() {
        return daySalary;
    }

    public void setDaySalary(double daySalary) {
        this.daySalary = daySalary;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        double income = this.getWorkDay() * this.getDaySalary() * this.getGrade();
        return "姓名：" + this.getName() + " 工作天数："
                + this.getWorkDay() + " 单日工资：" + this.getDaySalary()
                + " 总工资：" + income;
    }
}

class Manager extends Employee {
    private double bonus = 1000;
    public Manager(String name, double daySalary, int workDay) {
        super(name, daySalary, workDay);
    }

    public String toString() {
        double income = this.getWorkDay() * this.getDaySalary() * this.getGrade() * 1.2 + this.getBonus();
        return "姓名：" + this.getName() + " 工作天数："
                + this.getWorkDay() + " 单日工资：" + this.getDaySalary()
                + " 总工资：" + income + "其中奖金：" + this.getBonus();
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}

class Normal extends Employee {
    public Normal(String name, double daySalary, int workDay) {
        super(name, daySalary, workDay);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}