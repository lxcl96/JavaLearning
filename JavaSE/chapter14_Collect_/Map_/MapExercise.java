package chapter14_Collect_.Map_;

import java.util.*;

public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        Employee zs = new Employee("张三", 20000, 001);
        Employee ls = new Employee("李四", 25000, 002);
        Employee we = new Employee("王五", 18000, 003);
        Employee zl = new Employee("赵六", 35000, 004);
        map.put(zs.getId(), zs);
        map.put(ls.getId(), ls);
        map.put(we.getId(), we);
        map.put(zl.getId(), zl);
        System.out.println(map);
        System.out.println("方法一：entrySet");
        //entrySet
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            //对象 直接调用属性
            Map.Entry entry = (Map.Entry)next;
            Employee e = (Employee)entry.getValue();
            if (e.getSalary() > 18000) {
                System.out.println(entry.getKey() + ": " + e);
            }
        }
        System.out.println("方法二：keySet");
        //keySet
        Set set1 = map.keySet();
        for (Object o :set1) {
            Employee o1 = (Employee) map.get(o);
            if (o1.getSalary() > 18000) {
                System.out.println(o + ": " + o1);
            }
        }
        System.out.println("方法三：values");
        Collection values = map.values();
        for (Object value: values) {
            Employee o = (Employee) value;
            if (o.getSalary() > 18000) {
                System.out.println(o.getId() + ":" + o);
            }
        }
    }
}

class Employee {
    private String name;
    private double salary;
    private int id;

    public Employee(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "[" + name  + "-" + salary + ']';
    }
}