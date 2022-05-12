package chapter05_LogicDecision.Switch;
import java.util.Scanner;


public class SwitchExercise02 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = myScanner.nextInt();
        switch (month) {
            case 3:
            case 4:
            case 5: //利用穿透原理 减少语句
                System.out.println("是春季");break;
            case 6:
            case 7:
            case 8: //利用穿透原理 减少语句
                System.out.println("是夏季");break;
            case 9:
            case 10:
            case 11: //利用穿透原理 减少语句
                System.out.println("是秋季");break;
            case 12:
            case 1:
            case 2: //利用穿透原理 减少语句
                System.out.println("是冬季");break;
            default:
                System.out.println("无效输入");
        }
    }
}
