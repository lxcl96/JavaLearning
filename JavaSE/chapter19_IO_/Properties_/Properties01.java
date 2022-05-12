package chapter_19_IO_.Properties_;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description : 常规方法读取文件
 */
public class Properties01 {
    public static void main(String[] args) throws Exception{
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\Properties_\\mysql.properties";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();
        String s3 = bufferedReader.readLine();
        System.out.println("ip=" + s1.split("=")[1]);
        System.out.println("user=" + s2.split("=")[1]);
        System.out.println("pwd=" + s3.split("=")[1]);

        bufferedReader.close();
    }
}
