package chapter_19_IO_.打印流;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description : 字符打印流PrintWriter [可以直接打印到文件或流]
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter("d:\\a.txt");
        printWriter.println(1);
        printWriter.println("aaaa");
        printWriter.println('c');
        printWriter.println(3.2);

        printWriter.close();

        PrintWriter printWriter1 = new PrintWriter(System.out);//这样就打印到标准输出屏幕了
        printWriter1.println("哈哈");
        printWriter1.write("heheh");
        printWriter1.close();
    }
}
