package chapter07_Class;

public class HomeWork04 {
    public static void main(String[] args) {
        int[] arr = {5, 10, 1, 0, -1, 5};
        System.out.println("arr的hashCode()=" + arr.hashCode());
        A03 a03 = new A03();
        int[] arrNew;
        a03.print(arr);
        arrNew = a03.copyArr(arr);
        a03.print(arrNew);
        for (int i=0; i < arr.length; i++)
            arr[i] = 0;
        a03.print(arr);
        a03.print(arrNew);

    }
}
//实现数组的复制功能copyArr 输入旧数组 返回新数组 元素和旧数组一样
class A03 {
    public void print(int[] arr) {
        for (int n:arr)
            System.out.print(n + " ");
        System.out.println();
    }
    public int[] copyArr(int[] arr) {
        int[] arrNew = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            arrNew[i] = arr[i];
        System.out.println("arrNew的hashCode()=" + arrNew.hashCode());
        return arrNew;
    }
}