package chapter_19_IO_.字节输入流.InputStream_;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/3/31
 * @Description : 用FileInputStream读取hello.txt文件，并将其文件内容输出显示到控制台
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() throws IOException {
        String fileName = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\字节输入流\\InputStream_\\Hello.txt";
        byte[] bytes = new byte[8];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            //一个字节一个字节读取
            while (fileInputStream.available() > 0) {
                System.out.print((char)(fileInputStream.read()));//read读的是int ascii 需要转换一下
            }
        } catch (FileNotFoundException e) {
            System.out.println("没找到此文件");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //最后一定要关闭文件流，否则会造成资源浪费
            fileInputStream.close();
        }
    }

    @Test
    public void readFile02() throws IOException {
        //使用字节数据读取文件，提高效率
        String fileName = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\字节输入流\\InputStream_\\Hello.txt";
        byte[] bytes = new byte[8];
        int readlen = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            while ((readlen = fileInputStream.read(bytes)) != -1) {
                //另外一种方法
                //会读两次，而且readlen要根据实际来，否则比如写bytes.length=8，byte里面不够，后面的就无法覆盖，还会是上一次的
                //效果如下：
                //hello,wo
                //rld!o,wo
                System.out.println(new String(bytes,0,readlen));
            }

//            for (int i = 0; i < bytes.length; i++) {
//                System.out.print((char)bytes[i]);
//            }

        } catch (FileNotFoundException e) {
            System.out.println("没找到此文件");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //最后一定要关闭文件流，否则会造成资源浪费
            fileInputStream.close();
        }
    }
}
