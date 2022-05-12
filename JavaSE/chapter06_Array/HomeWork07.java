package chapter06_Array;

public class HomeWork07 {
    //打印数组
    public static void PrintIntgerArr(int arr[]) {
        for (int n : arr)
            System.out.print(n + "  ");
        System.out.println();
    }
    /*
        冒泡排序
        3 1 -1 2 7 10
        1 -1 2 3 7 10
        -1 1 2 3 7 10

     */
    public static void BubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            //对于有序数组 减少比较次数 (每次选出最大值)
            boolean changeTag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp  = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    changeTag = false;
                }
            }
            if (changeTag)
                break;
        }
    }

    public static void main(String[] args) {
        //指定数组大小
        int intgerNum = 10;
        int intgerArr[] = new int[intgerNum];

        for (int i = 0; i < intgerArr.length; i++) {
            //生成1到100的随机整数
            intgerArr[i] = (int)(100 * Math.random()) + 1;

        }
        System.out.println("打印随机数组：");
        PrintIntgerArr(intgerArr);
        BubbleSort(intgerArr);
        System.out.println("打印排序后数组：");
        PrintIntgerArr(intgerArr);

    }
}
