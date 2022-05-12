package chapter06_Array;

public class HomeWork05 {
    //打印数组
    public static void PrintIntgerArr(int arr[]) {
        for (int n : arr)
            System.out.print(n + "  ");
        System.out.println();
    }

    //倒叙打印数组
    public static void ReversePrint(int arr[]) {
        for (int i = arr.length - 1; i >= 0; i--)
            System.out.print(arr[i] + "  ");
        System.out.println();
    }


    public static void main(String[] args) {
        /*
        随机生成10个整数（1-100）到数组并倒叙打印，以及求平均值，求最大值和最大值的下标、并检查是否有8
         */
        //指定数组大小
        int intgerNum = 10;
        int intgerArr[] = new int[intgerNum];
        int index = -1;
        int maxNum = 0;
        boolean eightIs = false;

        for (int i = 0; i < intgerArr.length; i++) {
            //生成1到100的随机整数
            intgerArr[i] = (int)(100 * Math.random()) + 1;
            if (intgerArr[i] > maxNum) {
                maxNum = intgerArr[i];
                index = i;
            }
            if (intgerArr[i] == 8)
                eightIs = true;
        }
        System.out.println("打印随机数组：");
        PrintIntgerArr(intgerArr);
        System.out.println("倒叙打印随机数组：");
        ReversePrint(intgerArr);
        System.out.println("随机数组最大值为：" + maxNum + "，下标为：" + index);
        if (eightIs)
            System.out.println("随机数组有8");
        else
            System.out.println("随机数组无8");

    }
}
