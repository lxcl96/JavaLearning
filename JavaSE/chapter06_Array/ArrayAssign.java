package chapter06_Array;

public class ArrayAssign {
    public static void main(String[] args) {
        // 对于基本常量赋值，赋值方式为 拷贝
        int n1 = 10;
        int n2 = n1;
        // 改变n2的值不影响n1
        n2 = 90;
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);


        // 数组复制是传递地址 所以改变一个 另一个也跟着改变
        int a1[] = {1, 2, 3};
        int a2[] = a1;

        a2[0]= -1;
        System.out.println("a1 = " + a1[0]);
        System.out.println("a2 = " + a2[0]);
    }
}
