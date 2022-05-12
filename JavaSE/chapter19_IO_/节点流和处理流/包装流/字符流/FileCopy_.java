package chapter_19_IO_.节点流和处理流.包装流.字符流;

import java.io.*;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description :使用BufferedReader和BufferedWriter完成文件拷贝
 */
public class FileCopy_ {
    public static void main(String[] args) throws IOException {
        String desPath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\节点流和处理流\\包装流\\介绍.txt";
        String srcPath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\节点流和处理流\\介绍.txt";
        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(srcPath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(desPath));
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
