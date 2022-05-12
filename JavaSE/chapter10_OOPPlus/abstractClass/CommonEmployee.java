package chapter10_OOPPlus.abstractClass;

public class CommonEmployee extends Employee {
    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("员工" + this.getName() + "工作中...");
    }
}
