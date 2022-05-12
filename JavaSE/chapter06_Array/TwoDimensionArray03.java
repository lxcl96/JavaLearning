package chapter06_Array;

public class TwoDimensionArray03 {
    public static void main(String[] args) {
        //动态创建下面的二维 数组
        /*
            1
            2 2
            3 3 3
         */
        int arr[][] = new int[3][];//确定行 不确定列 可以这样声明
        for (int i = 0; i < arr.length; i++) {
            //给每个一维数组 行 单独开辟空间
            // 如果没有 开辟空间 则每个arr[i]均为null，内存地址不指向
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = i + 1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
