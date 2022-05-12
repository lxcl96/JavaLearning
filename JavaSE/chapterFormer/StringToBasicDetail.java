package chapterFormer;

// 演示字符串转基本数据类型细节
public class StringToBasicDetail {
    public static void main(String[] args) {
        String a = "123";
        //转成int
        String str = "hello";
        System.out.println(Integer.parseInt(a));
        System.out.println(Integer.parseInt(str));// except
    }
}
