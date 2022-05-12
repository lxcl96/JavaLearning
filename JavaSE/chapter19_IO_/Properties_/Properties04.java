package chapter_19_IO_.Properties_;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author : Ly
 * @Date : 2022/4/3
 * @Description : 使用Properties类完成对mysql2.properties的读取，并修改某个key-value
 */
public class Properties04 {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\Properties_\\mysql2.properties";
        FileReader fileReader = new FileReader(filePath);
        Properties properties = new Properties();

        properties.load(fileReader);
        properties.list(System.out);//指定输出到标准输出流
        properties.setProperty("user", "杰瑞");
        properties.setProperty("charset","gbk");

        properties.store(new FileWriter(filePath),null);
        fileReader.close();

    }
}
