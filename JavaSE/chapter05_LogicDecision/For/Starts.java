package chapter05_LogicDecision.For;
import java.util.Scanner;
/*
                    公式：2n-1                         n
                                                    |层数 空格头  头位置     个数
        *                   |     *     |     *     |6     5     6=n      1
        ***                 |    ***    |    * *    |6     4     5=n-1    2
        *****       ==>     |   *****   |   *   *   |6     3     4=n-2    2
        *******             |  *******  |  *     *  |6     2     3=n-2    2
        *********           | ********* | *       * |6     1     2=n-4    2
        ***********         |***********|***********|6     0     1=n-5    n
 */

public class Starts {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入要显示的层数：");
        int totalLevel = myScanner.nextInt();
        System.out.println("请输入要显示的符号：");
        String rec = myScanner.next();
        //金字塔
        for(int i = 0;i < totalLevel;i++) {
            //打印 每行开头空格
            for (int k = 0;k < totalLevel - i - 1;k++) {
                System.out.print(" ");
            }
            //打印 *
            for(int j = 1;j <= 2 * i + 1;j++) {
                if (1 < j && j < 2 * i + 1 && i < totalLevel - 1)
//                    System.out.print(rec.replace(rec," "));
                    System.out.print(" ");
                else
                    System.out.print(rec);
            }
            System.out.println("");
        }
    }
}
