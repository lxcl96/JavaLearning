package chapter_19_IO_.字符输入流.FileReader_;

/**
 * @Author : Ly
 * @Date : 2022/4/1
 * @Description : FileReaders介绍
 */
public class tips {
}
/*
    FileReader相关方法：
    1、new FileReader(File/String)
    2、read：每次读取一个字符（所以汉字不会乱码了），返回该字符，如果到文件末尾就返回-1
    3、read(char[]) 同上，每次读数组个大小长度
        new String(char[]) 将char[]转成String
        new String(char[],off,len)指定长度转成String
    */