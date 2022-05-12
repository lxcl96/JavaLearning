package chapter06_Array;
import java.util.Scanner;


public class Array02 {
    public static void main(String[] args) {
        //定义一个空数组 动态初始化

        //第三种方法 静态初始化
        double scores[] = {10, 2.2, 3.3, 4.4, 5.5};
        //第二种声明方法
//        double scores[];
//        scores = new double[5];
        //        double scores[] = new double[5];

        Scanner myScanner = new Scanner(System.in);
        for (int i =0; i < scores.length; i++) {
            System.out.println("请输入第" + i + "个元素的值");
            scores[i] = myScanner.nextDouble();
        }


        for (int i =0; i < scores.length; i++) {
            System.out.println("您输入的是：" + scores[i]);
        }
    }
}
