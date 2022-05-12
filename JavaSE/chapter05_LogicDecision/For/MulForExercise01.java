package chapter05_LogicDecision.For;
import java.util.Scanner;


public class MulForExercise01 {
    public static void main(String[] args) {
        // 3个班 每班5人 求出班级平均分和 总平均分
        double sum = 0;
        for (int i = 1;i <= 3;i++) {
            double glassSum = 0;
            for (int j = 1;j <=5;j++) {
                Scanner myScanner = new Scanner(System.in);
                System.out.println("请输入第" + i + "班，第" + j + "个学生的成绩");
                double score = myScanner.nextDouble();
                glassSum += score;
            }
            sum += glassSum;
            System.out.println("第" + i + "个班级平均分为：" + (glassSum / 5));
        }
        System.out.println("3个班平均分为:" + sum / 15);
    }
}
