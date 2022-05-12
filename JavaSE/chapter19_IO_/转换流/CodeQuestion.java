package chapter_19_IO_.转换流;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description : 乱码问题
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        //读取a.txt文件
        //1、创建一个字符输入流 bufferedReader（处理流）
        //2、bufferedReader 读取a.txt
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\转换流\\a.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        //没有指定读取文件的编码格式
        String s = br.readLine(); //默认正确读取Utf-8，如果是别的编码就会乱码
        System.out.println(s);

        br.close();
    }
}
