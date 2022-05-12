package chapter07_Class.This;

public class TestPerson {
    public static void main(String[] args) {
    Person p1 = new Person("大黄", 5);
    Person p2 = new Person("大黄", 5);
//    System.out.println(p1.compareTo("大黄", 5));
    System.out.println(p1.compareTo(p2));
    }
}
class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
//    public boolean compareTo(String name, int age) {
//        //this.name.equals(name)
//        if (name == this.name && age == this.age)
//            return true;
//        return false;
    public boolean compareTo(Person p) {
        return this.name.equals(p.name) && this.age == p.age;
    }
}