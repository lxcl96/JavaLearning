package chapter05_LogicDecision;

public class HomeWork08 {
    public static void main(String[] args) {
        //求出 1-1/2+1/3-1/4+。。。1/100
        double number = 1;

//        for (int i = 2;i <= 100; i++) {
//            if (i % 2 == 0)
//                number -= 1.0 / i;
//            else
//                number += 1.0 / i;
//        }
        // 第二种
        for (int i = 2;i <= 100; i++) {
            // 1/2 =0 但是1.0/2 =0.5
            number = number + Math.pow(-1, i-1) * 1.0 / i;
        }
        System.out.println(number);
    }
}
