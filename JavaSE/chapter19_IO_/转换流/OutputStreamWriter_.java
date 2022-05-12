package chapter_19_IO_.转换流;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description : 将字节流FileOutputStream包装成字符流OutputStreamWriter，对文件进行写入（可以指定编码）
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\转换流\\a.txt";
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true), "gbk"));

        bw.write("\n哈哈，这个是追加内容！");

        bw.close();
    }
}
