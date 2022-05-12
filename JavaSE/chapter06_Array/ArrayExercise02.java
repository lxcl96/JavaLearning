package chapter06_Array;

public class ArrayExercise02 {
    public static void main(String[] args) {
        // 求数组的最大值及其下标
        int a[] = {4, -1, 9, 10, 23};
        int max = a[0];
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                index = i;
            }
        }
        System.out.println("数组中最大得数为" + max + "，下标为" + index);
    }
}
