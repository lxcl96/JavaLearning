package chapter06_Array;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {24, 69, 80, 57, 13, 0, -1, 200, -200};
        int temp;
        System.out.println("冒泡排序：从小到大");
        // 只需走 n-1 趟
        for (int i = 0; i < arr.length - 1; i ++) {
            // 第一遍，找出一个最大值， 第二遍，找出两个最大值 。。。
            // 因此趟 比较的次数 都会减少 一个 因此是 arr.length - 1 - i 而不是 arr.length - 1 优化
            //有问题 写笔记分析就容易找出来了
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }

        for (int n : arr)
            System.out.print(n + "\t");
    }
}
