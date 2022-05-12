package chapter14_Collect_.Set_.HashSet_;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExercise {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        System.out.println(hashSet.add(new Employee("小红", 22)));
        System.out.println(hashSet.add(new Employee("小黄", 28)));
        System.out.println(hashSet.add(new Employee("小王", 30)));
        System.out.println(hashSet.add(new Employee("小红", 22)));

        System.out.println(hashSet);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Employee)) return false;
//        Employee employee = (Employee) o;
//        return age == employee.age && Objects.equals(name, employee.name);
//    }
    //----------
//    public boolean equals(Object o) {
//        if (this == o)  return true;
//        if (o == null||!(o instanceof Employee)) return false;
//        if (name == ((Employee) o).name && age == ((Employee) o).age) {
//            return true;
//        }
//        return false;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "["  + name  + ":" + age + ']';
    }
}
