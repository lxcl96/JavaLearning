package chapter08_intermediate._debug_;

public class debug01 {
    public static void main(String[] args) {
        Person hah = new Person("hah");
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
}