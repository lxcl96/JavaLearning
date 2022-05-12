package chapter07_Class.Recursion;
import java.util.Scanner;


public class RecursionExercise01 {
    public static void main(String[] args) {
        //使用递归 输入位置n 求出位置n代表的数字 即求出斐波那契数列 1 1 2 3 5 8 13 .。。
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数字n：");
        int index = input.nextInt();
        recursion re = new recursion();
        int number = re.FBNQ(index);
        System.out.println("第" + index + "个位置元素值为：" + number);

    }
}

class recursion {
    //递归
    public int FBNQ(int n) {
        if (n == 1 || n == 2)
            return 1;
        return FBNQ(n - 1 ) + FBNQ(n - 2 );
    }
}