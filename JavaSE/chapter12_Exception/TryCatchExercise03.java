package chapter12_Exception;

import java.util.Scanner;

public class TryCatchExercise03 {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("请输入一个整数：");
                int n = new Scanner(System.in).nextInt();
                break;
            } catch (Exception e) {
                System.out.println("您输入的不是一个整数,请继续输入!" + e);
            }
        }
        System.out.println("程序结束！");
    }
}
