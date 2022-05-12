package chapter15_Generics_;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericsExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom", 15000, new MyDate("03", "03", "1989")));
        employees.add(new Employee("jerry", 25000, new MyDate("10", "15", "1989")));
        employees.add(new Employee("king", 30000, new MyDate("01", "29", "1969")));
        employees.add(new Employee("tom", 8500, new MyDate("11", "03", "1989")));

        System.out.println(employees);

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getName().equals(o2.getName())) {
                    //这样不对 必须要都是两位
                    return o1.getBirthday().toString().compareTo(o2.getBirthday().toString());
                }
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (Employee e: employees) {
            System.out.println(e);
        }
    }
}


class MyDate {
    private String day;
    private String month;
    private String year;

    public MyDate(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}