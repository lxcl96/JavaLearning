package chapter_19_IO_.节点流和处理流.模拟包装流;

/**
 * @Author : Ly
 * @Date : 2022/4/1
 * @Description : 模拟处理/包装流
 */
public class BufferedReader_ extends Reader_{
    private Reader_ in;//

    public BufferedReader_(Reader_ in) {
        this.in = in;
    }

    //自定义方法，更快更方便的读取文件 即对Reader_的readFile()方法进行包装
    public void readFiles() {}
}
