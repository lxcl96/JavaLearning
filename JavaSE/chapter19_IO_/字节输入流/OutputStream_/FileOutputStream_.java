package chapter_19_IO_.字节输入流.OutputStream_;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/4/1
 * @Description : 向a.txt文件中写入”hello,world“.如果文件不存在会创建文件，前提是目录存在
 */
public class FileOutputStream_ {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = null;
        byte[] bytes = "\nhello, world".getBytes();
        String fileName = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\字节输入流\\OutputStream_\\a.txt";
        //fileOutputStream= new FileOutputStream(fileName);每次这样都是覆盖了之前的内容
        //fileOutputStream= new FileOutputStream(fileName,true);每次这样都是追加到文件末位
        try {
            fileOutputStream= new FileOutputStream(fileName, true);
            fileOutputStream.write(bytes);
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } finally {
            if (null != fileOutputStream)
                fileOutputStream.close();
        }

    }
}
