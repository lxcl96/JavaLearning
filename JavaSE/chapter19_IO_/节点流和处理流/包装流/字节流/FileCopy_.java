package chapter_19_IO_.节点流和处理流.包装流.字节流;

import java.io.*;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description : 用包装字节流拷贝图片
 */
public class FileCopy_ {
    public static void main(String[] args) throws IOException {
        String srcPath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\字节输入流\\des\\backgroud.jpg";
        String desPath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\节点流和处理流\\包装流\\字节流\\bg1.jpg";
        //int chr;
        int len;
        byte[] bytes = new byte[8];

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcPath));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(desPath));

//        while ((chr = bufferedInputStream.read()) != -1) {
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
        }

        bufferedInputStream.close();
        bufferedOutputStream.close();

    }
}
