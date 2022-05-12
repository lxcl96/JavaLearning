package chapter06_Array;

public class ArrayCopy {
    public static void main(String[] args) {
        //数组拷贝而不占用相同的空间
        int arr1[] = {-1, 0, 1};
        //int arr2[] = arr1; 这样是不行的
        // 思路：开辟新的数据空间，然后把遍历拷贝
        int arr2[] = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++)
            arr2[i] = arr1[i];

        arr2[1] = 10;
        for (int i = 0; i < arr1.length; i++)
            System.out.println("arr1[" + i + "] 是" + arr1[i] + "     arr2[" + i + "] 是" + arr2[i]);
    }
}
