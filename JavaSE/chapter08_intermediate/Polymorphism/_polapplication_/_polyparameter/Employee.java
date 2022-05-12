package chapter08_intermediate.Polymorphism._polapplication_._polyparameter;

public class Employee {
    private String name;
    private double salMonth;

    public Employee(String name, double salMonth) {
        this.name = name;
        this.salMonth = salMonth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(double salMonth) {
        this.salMonth = salMonth;
    }

    public double getAnnual() {
        return this.salMonth * 12;
    }
}
