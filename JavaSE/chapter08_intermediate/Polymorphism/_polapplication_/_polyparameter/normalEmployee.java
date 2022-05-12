package chapter08_intermediate.Polymorphism._polapplication_._polyparameter;

public class normalEmployee extends Employee{
    public normalEmployee(String name, double salMonth) {
        super(name, salMonth);
    }

    public void work() {
        System.out.println("员工" + super.getName() + "正在工作！");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
