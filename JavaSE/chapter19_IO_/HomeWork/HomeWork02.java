package chapter_19_IO_.HomeWork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/4/3
 * @Description : （1）使用BufferedReader读取一个文本文件，为每行加上一个行号，再连同内容一并输出到屏幕上
 */
public class HomeWork02 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\介绍.txt";
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String s;
        int i = 0;

        while ((s = br.readLine()) != null) {
            System.out.println((++i) + s);
        }

        br.close();

    }
}
