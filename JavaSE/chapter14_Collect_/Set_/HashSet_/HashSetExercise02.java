package chapter14_Collect_.Set_.HashSet_;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExercise02 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        MyDate d1 = new MyDate(1989, 01, 03);
        MyDate d3 = new MyDate(1989, 01, 03);
        MyDate d2 = new MyDate(1970, 11, 15);
        System.out.println(hashSet.add(new Employee02("张三", 30000, d1)));
        System.out.println(hashSet.add(new Employee02("李四", 15000, d2)));
        System.out.println(hashSet.add(new Employee02("赵五", 10000, d1)));
        System.out.println(hashSet.add(new Employee02("张三", 30000, d3)));
        System.out.println(hashSet);
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "[" +
                year +
                ":" + month +
                ":" + day +
                ']';
    }
}

class Employee02 {
    private String name;
    private double sal;
    MyDate birthday;

    public Employee02(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        return name.equals(((Employee02) obj).name) && birthday.getYear() == ((Employee02) obj).birthday.getYear()
        && birthday.getMonth() == ((Employee02) obj).birthday.getMonth() && birthday.getDay() == ((Employee02) obj).birthday.getDay();
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee02 that = (Employee02) o;
//        return Objects.equals(name, that.name) && Objects.equals(birthday, that.birthday); //直接用bjects.equals是不对的
//    }

    @Override
    public String toString() {
        return "["  + name  + "-" + sal + "-" + birthday + ']';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday.getYear(), birthday.getMonth(), birthday.getDay());//不能用birthday作为hash依据而要用日期
    }
}