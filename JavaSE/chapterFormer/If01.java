package chapterFormer;

import java.util.Scanner;


public class If01 {
    public static void main(String[] args) {
        int age ;
        Scanner myScanner = new Scanner(System.in);//输入
        System.out.println("请输入您的年龄：");
        age = myScanner.nextInt();
        if(age > 18) {
            System.out.println("你年龄大于18，要对自己的行为负责，送入监狱！");
        }
        System.out.println("End");
    }
}