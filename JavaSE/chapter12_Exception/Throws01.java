package chapter12_Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Throws01 {
    public static void main(String[] args) throws FileNotFoundException, NullPointerException {
        f1();//调用f1 必须处理了 ,或者使用throws抛出 一层层抛出最后是jvm 处理然后程序结束

        System.out.println("结束");

    }

    public static void f1() throws FileNotFoundException {
        //FileNotFoundExcept 编译异常必须处理
        //方法1、使用try-catch
        //方法2、使用throws 抛出异常，让调用f1()方法的 方法处理
        FileInputStream fileInputStream = new FileInputStream("dd://aaa.txt");
    }
}
/*

 */