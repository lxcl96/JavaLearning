package chapter08_intermediate.Polymorphism._polapplication_._polyparameter;

public class Manager extends Employee{
    private double bonus;

    public Manager(String name, double salMonth, double bonus) {
        super(name, salMonth);
        this.bonus = bonus;
    }

    public void manage() {
        System.out.println("经理" + this.getName() + "正在管理员工！");
    }
    @Override
    public double getAnnual() {
        return super.getAnnual() + this.bonus;
    }
}
