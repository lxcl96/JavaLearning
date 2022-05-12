package chapter05_LogicDecision.IF;
import java.util.Scanner;

public class IfExercise03 {
    public static void main(String[] args) {
        System.out.println("程序功能：判断一个年份是否是闰年？");
        /*
          规则：
          （1）年份能被4整除，但是不能被100整除
          （2）能被400整除 或的条件
         */
        int year;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入年份：");
        year = myScanner.nextInt();
        if(year % 4 == 0 && year % 100 !=0 || year % 400 == 0) {
            System.out.println("您输入的年份是：" + year + "，是闰年");
        }else{
            System.out.println("您输入的年份是：" + year + "，不是闰年");
        }

        System.out.println("Process Finish");
    }
}
