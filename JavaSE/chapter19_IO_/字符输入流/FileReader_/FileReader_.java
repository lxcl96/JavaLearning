package chapter_19_IO_.字符输入流.FileReader_;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/4/1
 * @Description : 使用FIleReader从story.txt中读取内容并显示
 */
public class FileReader_ {
    public static void main(String[] args) {
        //单个字符读取
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\字符输入流\\FileReader_";
        String fileName = "story.txt";
        String file = filePath + "\\" + fileName;
        FileReader fileReader = null;
        int c;

        try {
            fileReader = new FileReader(file);
            if (!fileReader.ready()) {
                System.out.println("无法读取文件，文件未准备好！");
                return;
            }
            while ((c = fileReader.read()) != -1) {
                System.out.print((char)c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void readChar() {

        //字符数组读取
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\字符输入流\\FileReader_";
        String fileName = "story.txt";
        String file = filePath + "\\" + fileName;
        FileReader fileReader = null;
        char [] chr = new char[8];
        int c;

        try {
            fileReader = new FileReader(file);
            if (!fileReader.ready()) {
                System.out.println("无法读取文件，文件未准备好！");
                return;
            }
            //返回实际读取到的字符数
            while ((c = fileReader.read(chr)) != -1) {
                //System.out.println("***" + c);
                System.out.println(new String(chr,0,c));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
