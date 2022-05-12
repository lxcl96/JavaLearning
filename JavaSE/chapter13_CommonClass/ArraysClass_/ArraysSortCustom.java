package chapter13_CommonClass.ArraysClass_;


import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortCustom {
    //常规冒泡  从小到大
    public static void bubble(int[] arr){
        int tmp = 0;
        for (int i = 0; i < arr.length -1 ; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }

        }
    }

    //使用比较函数来定制，升序还是降序
    public static void bubble2(int[] arr, Comparator c) {
        int tmp = 0;
        for (int i = 0; i < arr.length -1 ; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) { // arr[j] > arr[j+1] 不就是 arr[j] - arr[j+1] > 0
                    tmp = arr[j];                       // arr[j] < arr[j+1] 不就是 arr[j+1] - arr[j] > 0
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }

        }
    }
    /*
        5 4 2 0 -1 -2

     */
    public static void main(String[] args) {
        int[] arr = {2, 0 ,-1, -2, 5, 4};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
        //定制排序
        bubble2(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer)01;
                int i2 = (Integer)02;
                return i2 - i1;
            }
        });
        System.out.println(Arrays.toString(arr));

    }
}
