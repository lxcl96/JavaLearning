package chapter07_Class.Overload;

public class OverLoad01 {
    public static void main(String[] args) {
        Mycalculator my = new Mycalculator();
        System.out.println(my.calculate(1,1));
        System.out.println(my.calculate(1, 1.0));
        System.out.println(my.calculate(1.0, 1));
        System.out.println(my.calculate(1, 1, 1));

    }
}

class  Mycalculator {
    public int calculate(int n1, int n2) {
        return n1 + n2;
    }

    public double calculate(int n1, double n2) {
        return n1 + n2;
    }

    public double calculate(double n1, int n2) {
        return n1 + n2;
    }

    public int calculate(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }
}
