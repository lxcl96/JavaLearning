package chapter_19_IO_.节点流和处理流.模拟包装流;

/**
 * @Author : Ly
 * @Date : 2022/4/1
 * @Description : 使用BufferedReader_
 */
public class Test_ {
    public static void main(String[] args) {
        BufferedReader_ bufferedReader_ = new BufferedReader_(new FileReader_());


        bufferedReader_.readFile();//原来简单的方法
        bufferedReader_.readFiles();//扩展后更强大的方法
    }
}
