package chapter_19_IO_.Properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description :
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\Properties_\\mysql.properties";

        Properties properties = new Properties();
        FileReader br = new FileReader(filePath);//直接FileReader就行了
        properties.load(br);
        //显示到控制台
        properties.list(System.out);

        //获取指定键值对信息
        System.out.println(properties.getProperty("ip"));
        System.out.println(properties.getProperty("user"));
        System.out.println(properties.getProperty("pwd"));

        br.close();
    }
}
