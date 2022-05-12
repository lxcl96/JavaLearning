package chapter05_LogicDecision.While;
import java.util.Scanner;


public class DoWhileExercise02 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        char answer;
        do {
            System.out.println("五连鞭");
            System.out.println("老汉问：还钱吗？ y/n");
            answer = myScanner.next().charAt(0);
        } while (answer != 'y');
    }
}
