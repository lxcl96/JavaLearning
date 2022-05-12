package chapter07_Class;

public class HomeWork02 {
    public static void main(String[] args) {
        String[] str = {"hello", "Good Morning", "AfterNoon"};
        A02 a02 = new A02();
        System.out.println(a02.find(str, "AfterNoon"));
    }
}
//find方法 实现查找某字符串数组中的元素查找，并返回所有，如果没找到返回-1
class A02 {
    public int find(String[] str, String keyStr) {
        for (int i = 0;i < str.length; i++) {
            if(keyStr.equals(str[i]))
                return i;
        }
        return -1;
    }
}