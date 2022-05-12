package chapter07_Class;

public class HomeWork01 {
    public static void main(String[] args) {
        double[] arr1 = {0.1, 1.0, 2.2 -0.1, 10};
        A01 a01 = new A01();
        System.out.println("数组最大数据为： " + a01.max(arr1));
    }
}

//编写类A01 定义方法max 实现求某个double数组的最大值 并返回
class A01 {
    public double max(double[] arr) {
        //double是数据类型  Double是类 对象
        double max = arr[0];
        for (double n : arr) {
            if (n > max)
                max =n;
        }
        return max;
    }
}