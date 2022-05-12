package chapter06_Array;

public class ArrayReverse {
    public static void main(String[] args) {
        int arr1[] = {11, 22, 33, 44, 55, 66};
        int temp;
        int midIndex;
//        if (arr1.length % 2 == 0)
//            midIndex = arr1.length / 2 - 1;
//        else
//            midIndex = arr1.length / 2;
        midIndex = arr1.length / 2; //优化之后的
        for (int i = 0; i < midIndex; i++) {
            temp = arr1[i];
            arr1[i] = arr1[arr1.length - 1 - i];
            arr1[arr1.length - 1 - i] = temp;
        }

        for (int i = 0; i < arr1.length; i++)
            System.out.println(arr1[i]);
    }
}
