package chapter06_Array;
import java.util.Scanner;


public class ArrayReduce {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        Scanner myScanner = new Scanner(System.in);
        while (true) {
            if (arr.length == 1) {
                System.out.println("数组只有一个元素无法继续缩减。");
                break;
            }

            System.out.println("是否缩减最后一个元素？ y/n");
            char key = myScanner.next().charAt(0);
            if (key == 'n')
                break;

            int arrNew[] = new int[arr.length - 1];
            for (int i = 0; i < arrNew.length; i++)
                arrNew[i] = arr[i];
            arr = arrNew;
        }

        System.out.println("新数组为：");
        for (int n : arr)
            System.out.print(n + "\t");
    }
}
