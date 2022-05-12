package chapter05_LogicDecision.IF;
import java.util.Scanner;


public class If03 {
    public static void main(String[] args) {
        int antTruth;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入保国同志的芝麻信用分：");
        antTruth = myScanner.nextInt();
        if(antTruth == 100) {
            System.out.println("保国同志信用极好");
        } else if(antTruth <= 99 && antTruth > 80) {
            System.out.println("保国同志信用优秀");
        } else if(antTruth <=80 &&antTruth >= 60) {
            System.out.println("保国同志信用一般");
        } else {
            System.out.println("保国同志信用不及格");
        }
    }
}
