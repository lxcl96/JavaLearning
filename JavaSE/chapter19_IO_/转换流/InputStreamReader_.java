package chapter_19_IO_.转换流;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description :  InputStreamReader 指定编码格式读取文件
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\JavaWork\\JavaLearning\\src\\chapter_19_IO_\\转换流\\a.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "utf8");

        //最终还是要用bufferedReader读取，因为功能更强大

//        int chr;
//        while ((chr = isr.read()) != -1) {
//            System.out.print((char) chr);
//        }
        BufferedReader bufferedReader = new BufferedReader(isr);
        String s = bufferedReader.readLine();
        System.out.println(s);
        System.out.println(bufferedReader.readLine());
        isr.close();
    }
}
