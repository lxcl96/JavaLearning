package chapter_19_IO_.节点流和处理流.包装流.字符流;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description : 1、BufferedReader/BufferedWriter属于字符流，是按照字符来读取数据的
 *                2、关闭处理流时，只需要关闭外层流[处理流，处理流会自动关闭节点流]即可
 */
public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\资源池\\Oracle定时备份.bat";
        String res = null;
        //BufferedReader接收Reader类型，但是Reader无法实例化所以就选择FileReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //返回null表示到文件末尾
        while ((res = bufferedReader.readLine()) != null) {
            System.out.println(res);
        }

        //本身是需要关闭节点流FileReader，但是实际上只需关闭包装流bufferedReader即可，因为底层会自己关闭节点流FileReader
        bufferedReader.close();

    }
}
