package chapter_19_IO_.节点流和处理流.包装流.字符流;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description :BufferedWriter使用
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\bufferedWriter.txt";
        //不加true就覆盖，但是不是写一行就覆盖一行的，而是以close保存了为一次覆盖
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));

        bufferedWriter.write("hsp,教育\n");
        bufferedWriter.write('n');
        bufferedWriter.newLine();
        bufferedWriter.write("唯手熟尔".toCharArray(),1,2);

        //关闭外层流（即包装流即可）
        bufferedWriter.close();

    }
}
