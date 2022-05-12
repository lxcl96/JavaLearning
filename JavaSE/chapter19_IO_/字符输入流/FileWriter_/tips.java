package chapter_19_IO_.字符输入流.FileWriter_;

/**
 * @Author : Ly
 * @Date : 2022/4/1
 * @Description : FileWriter介绍
 */
public class tips {
}
/*
    FFileWriter相关方法：
    1、new FileWriter(File/String) 覆盖模式，每次都是覆盖写入
    2、new FileWriter(File/String，true) 追加模式，每次都是追加写入
    3、writer(int)：每次写入一个字符
    4、writer(char[]) 写入一个数组
    5、writer(char[],off,len) 写入一个指定长度数组
    6、writer(string) 写入整个字符串
    7、writer(string,off,len) 写入指定长度字符串

        String.toCharArray[]将String转化成char[]

     注意：
     FileWriter写入后，必须关闭close或者刷新flush，否则无法写入（就是不保存）
    */