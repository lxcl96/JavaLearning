package chapter05_LogicDecision.IF;
import java.util.Scanner;


public class IfExercise02 {
    public static void main(String[] args) {
        System.out.println("程序功能：判断两数之和是否可以被3和5整除。");
        int var1, var2, ret;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入变量var1的值：");
        var1 = myScanner.nextInt();
        System.out.println("请输入变量var2的值：");
        var2 = myScanner.nextInt();
        ret = var1 + var2;
        if(ret % 3 == 0 && ret % 5 == 0) {
            System.out.println("两数之和为：" + ret + "，既能够被3整除，也能被5整除。");
        }
        else if(ret % 3 == 0){
            System.out.println("两数之和为：" + ret + "，只能够被3整除。");
        }
        else if(ret % 5 == 0){
            System.out.println("两数之和为：" + ret + "，只能够被被5整除。");
        }
        else {
            System.out.println("两数之和为：" + ret + "，既不能够被3整除，也不能被5整除。");
        }

        System.out.println("Process Finish");
    }
}
