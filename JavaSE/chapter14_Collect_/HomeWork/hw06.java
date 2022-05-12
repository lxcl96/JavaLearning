package chapter14_Collect_.HomeWork;

import java.util.HashSet;
import java.util.Objects;

public class hw06 {
    public static void main(String[] args) {
        //HashSet
        HashSet set = new HashSet();
        Person1 p1 = new Person1(1001, "AA");
        Person1 p2 = new Person1(1002, "BB");
        set.add(p1);
        set.add(p2);
        System.out.println("p1.hashcode=" + p1.hashCode());
        System.out.println("p2.hashcode=" + p2.hashCode());
        System.out.println(set);
        p1.name = "CC";
        System.out.println("new p1.hashcode=" + p1.hashCode());
        System.out.println(set);
        set.remove(p1);
        Person1 p3 = new Person1(1001, "CC");
        set.add(p3);
        System.out.println("p3.hashcode=" +  p3.hashCode());
        System.out.println(set);

        Person1 p4 = new Person1(1001, "AA");
        set.add(p4);
        System.out.println("p4.hashcode=" +  p4.hashCode());
        System.out.println(set);



    }
}
class Person1 {
    public String name;
    public int id;

    public Person1(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person1 person1 = (Person1) o;
        return id == person1.id && Objects.equals(name, person1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "[" + id + ":" + name + "]";
    }
}