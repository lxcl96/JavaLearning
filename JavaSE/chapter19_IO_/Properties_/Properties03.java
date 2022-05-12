package chapter_19_IO_.Properties_;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description : 添加键值对到新文件mysql2.propert
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //FileWriter fileWriter = new FileWriter("//mysql2.properties");
        FileWriter fileWriter = new FileWriter("D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\Properties_\\mysql2.properties");

        properties.setProperty("date","2020/04/03");
        properties.setProperty("charset","utf8");
        properties.setProperty("user","汤姆");//fileWriter存储的就是 汤姆【字符流】
                                            //FIleInputStream存储的是 汤姆 的unicode编码【字节流】
        properties.store(fileWriter,"第一次尝试,this is a test!");


        fileWriter.close();
    }
}
