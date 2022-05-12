package chapter10_OOPPlus;

public class HomeWork06 {
    public static void main(String[] args) {
        //初始值骑马
        Person ts = new Person("唐僧", TransportFactory.getHorse());
        //后面遇到河换交通工具 ，如果还是一般情况就不换



    }
}

interface Vehicles {
    void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("骑马");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("轮渡");
    }
}

class TransportFactory {
    //用类创建，就不用自己在main中创建了
    public static Horse getHorse() {return new Horse();}

    public static Boat getBoat() {return new Boat();}

}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRevier() {
        if (vehicles instanceof Horse) {
            TransportFactory.getBoat().work();
        }
    }

    public void common() {
        if (vehicles instanceof Boat) {
            TransportFactory.getHorse().work();
        }
    }
}