package chapter05_LogicDecision.Switch;
import java.util.Scanner;

/*
    switch有穿透原则，即每个case必须加上break否则会依次执行而管后面的case条件
 */
public class Switch01 {
    public static void main(String[] args) {
        char input;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入字符");
        input = myScanner.next().charAt(0);
        switch (input) {
            case 'a':
                System.out.println("输入a,代表星期一");
//                break;
            case 'b':
                System.out.println("输入b,代表星期二");
                break;
            case 'c':
                System.out.println("输入c,代表星期三");
                break;
            case 'd':
                System.out.println("输入d,代表星期四");
                break;
            case 'e':
                System.out.println("输入e,代表星期五");
                break;
            case 'f':
                System.out.println("输入f,代表星期六");
                break;
            case 'g':
                System.out.println("输入g,代表星期日");
                break;
            default:
                System.out.println("输入错误");
        }
    }
}
