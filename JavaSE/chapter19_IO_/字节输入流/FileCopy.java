package chapter_19_IO_.字节输入流;

import java.io.*;

/**
 * @Author : Ly
 * @Date : 2022/4/1
 * @Description : 编程完成图片/音乐的拷贝
 */
public class FileCopy {
    public static void main(String[] args) {
        String srcPic = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\字节输入流\\OutputStream_\\backgroud.jpg";
        String srcMp3 = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\字节输入流\\OutputStream_\\fly.mp3";
        String desMp3 = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\字节输入流\\fly.mp3";
        String desPic = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\字节输入流\\des\\backgroud.jpg";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        byte[] bytes = new byte[1];
        int count = 0;

        try {
//            fileInputStream = new FileInputStream(srcPic);
//            fileOutputStream = new FileOutputStream(desPic, true);
//            //可以定义一个数组，提高效率
//            while (fileInputStream.available() > 0) {//读取一个字节写入一个字节，减少内存
//                fileOutputStream.write(fileInputStream.read());
//            }
            fileInputStream = new FileInputStream(srcPic);
            fileOutputStream = new FileOutputStream(desPic, true);
            //可以定义一个数组，提高效率
            while ((count = fileInputStream.read(bytes)) != -1) {//读取一个字节写入一个字节，减少内存
                fileOutputStream.write(bytes,0,count);
            }
            System.out.println("照片拷贝成功");
        } catch (IOException var) {
            var.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
