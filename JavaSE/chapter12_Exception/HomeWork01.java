package chapter12_Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWork01 {
    public static void main(String[] args) {
        System.out.println("程序功能：计算n1/n2");
        try {
            System.out.println("请输入n1的值：");
            int n1 = new Scanner(System.in).nextInt();
            System.out.println("请输入n2的值：");
            int n2 = new Scanner(System.in).nextInt();

            EcmDef.cal(n1, n2);
        } catch (InputMismatchException e) {
            System.out.println("异常：数据类型不正确");
        }

    }
}

class EcmDef {
    public static void cal(int n1, int n2) {
        int n = 0;
        try {
            n =  n1 / n2;
        } catch (ArithmeticException e) {
            System.out.println("异常：除数为0");
            return ;
        }
        System.out.println("结果为：" + n);
    }
}