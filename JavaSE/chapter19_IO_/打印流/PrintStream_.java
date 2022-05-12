package chapter_19_IO_.打印流;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description : 字节打印流,记住System.out就是一个实例化对象【如Cat cat；的cat】，方法直接调用就行
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        //默认情况下，PrintStream输出数据的位置是标准输出即显示器

        out.println("hello，world");//就是System.out.println()
        out.println();//底层就是下面的write()函数
        out.write("hello,world".getBytes());


        //我们可以修改打印流的输出位置
        //PrintStream printStream = new PrintStream("D:\\aaa.txt");
        //System.setOut(printStream);
        //printStream.write("hello,world".getBytes());

        //等同于
        System.setOut(new PrintStream("D:\\aaa.txt"));
        System.out.println("ni好，大傻逼！");
        out.close();
        System.out.close();//可以不用，因为是匿名对象 用完就回收了
    }
}
