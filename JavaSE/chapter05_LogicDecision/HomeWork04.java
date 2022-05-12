package chapter05_LogicDecision;
import java.util.Scanner;


public class HomeWork04 {
    public static void main(String[] args) {
        //水仙花数判断 153 = 1*1*1 + 5*5*5  + 3*3*3
        System.out.println("水仙花数判断 例如：153 = 1*1*1 + 5*5*5  + 3*3*3 ");
        Scanner myScanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要判断的数字： (按999退出)");
            int number = myScanner.nextInt();
            if (number == 999)
                break;
            // 取数字的个位 十位 百位 可以将其转化为字符 另一种方法 数学上
            int geWei = number % 10;
            int shiWei = (number / 10) % 10;
            int baiWei = (number / 100) % 10;
            if(number == Math.pow(geWei, 3) + Math.pow(shiWei, 3) + Math.pow(baiWei, 3)) {
                System.out.println(number + "是水仙花数！");
                continue;
            }
            System.out.println(number + "不是水仙花数，请重新输入。");
        }
    }
}
