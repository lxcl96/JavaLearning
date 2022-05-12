package chapter06_Array;

public class HomeWork01 {
    public static void main(String[] args) {
        //三种正确的声明方法
        String str[] = {"a", "b", "c"};
        String str2[] = new String[3];
        String str1[] = new String[]{"d", "e", "f"};


        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
    }
}
