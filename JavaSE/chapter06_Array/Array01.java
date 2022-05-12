package chapter06_Array;

public class Array01 {
    public static void main(String[] args) {
        //double hens double
        // 两种声明方式
        double [] hens = {3, 5, 1, 3.4, 2, 50}; //一组double
        double hens1[] = {3, 5, 1, 3.4, 2, 50}; //一组double
        /*
        int a[] = new int[5]
        类型 名字[] = New 类型[大小]
         */
        //数组长度为 6 但是下标从0 开始 不能取到等于
        for (int i = 0;i < hens.length; i++) {
            System.out.println(hens[i]);
        }
    }
}
