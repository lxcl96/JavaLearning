package chapter_19_IO_.标准输入输出流;

/**
 * @Author : Ly
 * @Date : 2022/4/2
 * @Description : 标准输入输出流
 */
public class StandInputAndOutput {
    public static void main(String[] args) {
        // public final static InputStream in = null;
        //可以看出 System.in的编译类型为 InputStream 运行类型为：BufferedInputStream
        //表示标准输入 键盘
        //用法Scanner(System.in)
        System.out.println(System.in.getClass());//BufferedInputStream


        //public final static PrintStream out = null;
        //可以看出 System.out的编译类型为 PrintStream 运行类型为：PrintStream
        //表示标准输出  显示器
        //用法System.out.println
        System.out.println(System.out.getClass());//PrintStream
    }
}
