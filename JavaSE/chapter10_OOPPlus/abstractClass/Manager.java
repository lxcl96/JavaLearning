package chapter10_OOPPlus.abstractClass;

public class Manager extends Employee{
    private double bonus;

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理" + this.getName() + "正在工作中...");
    }
}
