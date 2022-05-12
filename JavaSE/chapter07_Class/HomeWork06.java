package chapter07_Class;

public class HomeWork06 {
    public static void main(String[] args) {
        cale c1 = new cale();
        cale c2 = new cale();
        double number1 = 2;
        double number2 = 1;

        double number3 = 2;
        double number4 = 0;
        System.out.println(c1.add(number1, number2));
        System.out.println(c1.subtract(number1, number2));
        System.out.println(c1.multiplication(number1, number2));
        System.out.println(c1.division(number1, number2));

        System.out.println(c2.add(number3, number4));
        System.out.println(c2.subtract(number3, number4));
        System.out.println(c2.multiplication(number3, number4));
        if (c2.division(number3, number4) == null)
            System.out.println("非法除数0");
        else
            System.out.println(c2.division(number3, number4));

    }
}
//实现 +-*/ 除数为0提示
class cale {

    public double add(double number1, double number2) {
        return number1 + number2;
    }

    public double subtract(double number1, double number2) {
        return number1 - number2;
    }

    public double multiplication(double number1, double number2) {
        return number1 * number2;
    }

    public Double division(double number1, double number2) {
        if (number2 == 0)
            return null;
        return number1 / number2;
    }

}