package chapter14_Collect_.Set_.LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Objects;

public class LinkedHashSetExercise {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        System.out.println(linkedHashSet.add(new Car("奥拓", 10000)));
        System.out.println(linkedHashSet.add(new Car("奥迪", 300000)));
        System.out.println(linkedHashSet.add(new Car("法拉利", 10000000)));
        System.out.println(linkedHashSet.add(new Car("奥迪", 300000)));
        System.out.println(linkedHashSet.add(new Car("保时捷", 7000000)));
        System.out.println(linkedHashSet.add(new Car("奥迪", 3000000)));
        System.out.println(linkedHashSet);
    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + name + ':' + price + ']';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        return name.equals(((Car) obj).name)&&price == ((Car) obj).price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}