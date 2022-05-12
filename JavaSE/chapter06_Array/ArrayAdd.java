package chapter06_Array;
import java.util.Scanner;


public class ArrayAdd {
    public static void main(String[] args) {
        //实现动态给数组添加元素
        int arr[] = {1, 2, 3};
        Scanner myScanner = new Scanner(System.in);
       while (true) {
           int arrNew[] = new int[arr.length + 1];
           for (int i = 0; i < arr.length; i++)
               arrNew[i] = arr[i];
           System.out.println("请输入要添加的元素: ");
           //arrNew[] = {1, 2, 3, 4};
           arrNew[arrNew.length - 1] = myScanner.nextInt();
           arr = arrNew;
           System.out.println("是否继续执行？ y/n ");
           char goON = myScanner.next().charAt(0);
           if (goON == 'n')
               break;
       }

       System.out.println("新数组元素为：");
       for (int n : arr)
           System.out.print(n + "\t");

    }
}
