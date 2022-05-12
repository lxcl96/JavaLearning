package chapter06_Array;

public class YangHuiTriangle {
    public static void main(String[] args) {
        //声明行 列未知
        int row = 10;
        //声明二维数组
        int triAngle[][] = new int[row][];
        //前两行手动定义
        triAngle[0] = new int[1];
        triAngle[1] = new int[2];
        triAngle[0][0] = 1;
        triAngle[1][0] = 1;
        triAngle[1][1] = 1;
        //第三行开始使用 代码生成
        for (int i = 2; i < triAngle.length; i++) {
            triAngle[i] = new int[i + 1];
            triAngle[i][0] = 1;
            triAngle[i][triAngle[i].length - 1] = 1;
            for (int j = 1; j < i; j++) { // j < i而不是 j < i - 1
                //
                triAngle[i][j] = triAngle[i - 1][j - 1] + triAngle[i - 1][j];
            }
        }

        //另外一种方法 可以忽略 i -1 不够的错误
        /*

        for (int i = 0; i < triAngle.length; i++) {
            triAngle[i] = new int[i + 1];
            for (int j = 0; j < i; j++) { // j < i而不是 j < i - 1 或者 triAngle[i].length -1
                if (j == 0 || j == triAngle[i].length -1 )
                    triAngle[i][j] = 1;
                 else
                    triAngle[i][j] = triAngle[i - 1][j - 1] + triAngle[i - 1][j];
            }
        }



         */

        for (int i = 0; i < triAngle.length; i++) {
            for (int j = 0; j < triAngle[i].length; j++)
                System.out.print(triAngle[i][j] + " ");
            System.out.println();
        }
    }
}
