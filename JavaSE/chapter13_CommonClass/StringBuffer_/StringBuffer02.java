package chapter13_CommonClass.StringBuffer_;

public class StringBuffer02 {
    public static void main(String[] args) {
        //1. 会创建大小为 16的字符串数组，由StringBuffer的父类AbstractStringBuilder提供构造方法
        //      所以说StringBuffer 实际存储在父类AbstractStringBuilder中
        StringBuffer stringBuffer = new StringBuffer();

        //2. 通过构造器指定大小
        StringBuffer stringBuffer1 = new StringBuffer(32);

        //3. 直接传递字符串，现在value[]大小为 【字符串的长度+16】 21
        StringBuffer hello = new StringBuffer("hello");
        System.out.println(hello.length());//5 空的被舍弃，可以debug看
    }
}
