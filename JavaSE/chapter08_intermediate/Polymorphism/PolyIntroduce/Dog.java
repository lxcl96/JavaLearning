package chapter08_intermediate.Polymorphism.PolyIntroduce;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
