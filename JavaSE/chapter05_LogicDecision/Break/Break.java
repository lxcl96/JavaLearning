package chapter05_LogicDecision.Break;
//import java.util.Random;

public class Break {
    public static void main(String[] args) {
//        Random myRandom = new Random();
//        System.out.println(myRandom);
//        System.out.println(num);
        int i = 0;
        while (true) {
            int n = (int)(Math.random() * 100);
            i++;
//            double num = myRandom.nextDouble();
//            int n = (int)(num * 100);
//            System.out.println(n);
            if (n == 97)
                break;
        }
        System.out.println(i);
    }
}
