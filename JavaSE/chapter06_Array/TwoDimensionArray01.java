package chapter06_Array;

public class TwoDimensionArray01 {
    public static void main(String[] args) {
        //  二维数组
        /*
        输出：
        0 0 0 0 0
        0 0 1 0 0 0
        2 0 3 0 0
        0 0 0 0 0
         */
        int arr[][] = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {2, 0, 3, 0, 0}, {0, 0, 0, 0, 0}};
        // arr.length =4 代表行长度   arr[i].length代表第i行的列长度
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
