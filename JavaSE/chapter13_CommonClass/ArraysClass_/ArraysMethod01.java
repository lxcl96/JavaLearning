package chapter13_CommonClass.ArraysClass_;

import java.util.Arrays;
import java.util.Comparator;

/*
    Arrays.toString()
 */
public class ArraysMethod01 {
    public static void main(String[] args) {
        Integer[] arr = {1, -1, 7, 0, 89};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //定制排序 从大到小 【在匿名内部类中定制】
        /*
            1、调用定制排序时，需要传递两个参数 待排序数组和 实现Comparator接口的匿名内部类
         */
        Arrays.sort(arr, new Comparator() {  //原理参考ArraysSortCustom.java

            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2 - i1;//改成i1 -i2就是从小到大排序  可以debug查看
            }
        });
        System.out.println(Arrays.toString(arr));


    }
}
