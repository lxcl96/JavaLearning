package chapter05_LogicDecision.For;

import java.util.Scanner;

public class MulForExercise02 {
    public static void main(String[] args) {
        //统计3个班及格人数，每个班级有5人
         int count = 0;
        for (int i = 1;i <= 3;i++) {
            int num = 0;
            for (int j = 1;j <=5;j++) {
                Scanner myScanner = new Scanner(System.in);
                System.out.println("请输入第" + i + "班，第" + j + "个学生的成绩");
                double score = myScanner.nextDouble();
                if (score >= 60.0) {
                    num++;
                }
            }
            count += num;
            System.out.println("第" + i + "个班级共及格" + num + "人");
        }
        System.out.println("3个班总及格人数为:" + count);
    }
}
