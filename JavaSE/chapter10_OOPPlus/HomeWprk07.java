package chapter10_OOPPlus;

public class HomeWprk07 {
    public static void main(String[] args) {
        new Car(0).new Air();
        new Car(-1).new Air();
        new Car(40).new Air();
        new Car(41).new Air();
    }
}

class Car {
    private int temperature;

    public Car(int temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow(String tag) {
            System.out.println("吹" + tag);
        }

        public Air() {
            if (temperature < 0) {
                flow("暖风");
            } else if (temperature > 40) {
                flow("冷风");
            } else System.out.println("关闭空调");
        }
    }


}