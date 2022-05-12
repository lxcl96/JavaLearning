package chapter13_CommonClass.StringBuffer_;

public class tips {
    public static void main(String[] args) {
        StringBuffer hello = new StringBuffer("hello");
        hello.insert(3,"88");
        System.out.println(hello);
    }
}
/*
    java.lang.StringBuffer代表可变的字符序列,可以对字符串内容进行增删

    很多方法和String的方法相同,但StringBuffer是可变长度'

    StringBuffer是一个容器
 */