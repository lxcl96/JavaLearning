package chapter05_LogicDecision.IF;
import java.util.Scanner;


public class NestedIf {
    public static void main(String[] args) {
        double score;
        char sex;
        String str = "a1b2c3";
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入选手的分数：" + str.charAt(0));
        score = myScanner.nextDouble();

        if (score > 8.0) {
            System.out.println("请输入选手的性别（男/女）：");
            sex = myScanner.next().charAt(0);
            if (sex == '男')
                System.out.println("初赛成绩大于8.0，进入男子组决赛！");
            else
                System.out.println("初赛成绩大于8.0，进入女子组决赛！");
        } else {
            System.out.println("初赛成绩小于8.0，已淘汰！");
        }
    }
}
