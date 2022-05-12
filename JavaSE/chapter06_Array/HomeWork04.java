package chapter06_Array;

public class HomeWork04 {
    public static void main(String[] args) {
        /*
        有序数组 [10, 12, 45, 90] 插入 23  ==》 [10, 12, 23, 45, 90]
         */
        int arr[] = {10, 12, 45, 90};
        int addNum = 23;
        int changeTag = 0;
        int arrNew[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            //找到第一个比addNum大的值，addNum占用它的坑位
            if (addNum <= arr[i] && changeTag == 0) {
                arrNew[i] = addNum;
                //为了对标旧数组
                i--;
                changeTag += 1;
                continue;
            }
            arrNew[i + changeTag] = arr[i];
        }
        //如果循环结束了 changeTag还为0 说明addNum为最大值，手动放在最后
        if (changeTag == 0)
            arrNew[arrNew.length - 1] = addNum;

        arr = arrNew;
        for (int n : arr)
            System.out.print(n + "  ");
    }
}
