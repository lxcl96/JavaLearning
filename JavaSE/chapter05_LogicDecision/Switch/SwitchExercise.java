package chapter05_LogicDecision.Switch;
import java.util.Scanner;


public class SwitchExercise {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入学生成绩：");
        int score = myScanner.nextInt() / 60;
        switch (score) {
            case 1:
                System.out.println("合格");
                break;
            default:
                System.out.println("不合格");
        }
    }
}
