package chapter05_LogicDecision.IF;
import java.util.Scanner;


public class IfExercise01 {
    public static void main(String[] args) {
        double a, b, ret;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入a的值：");
        a = myScanner.nextDouble();
        System.out.println("请输入b的值：");
        b = myScanner.nextDouble();

        if(a > 10.0 && b < 20.0) {
            ret = a + b;
            System.out.println("两数之和为：" +ret );
        }
        System.out.println("process finish");
    }
}
