package chapter13_CommonClass.StringClass_;

public class String01 {
    public static void main(String[] args) {
        //String中不论是汉字 还是 字母都占用两个字节
        String s = "li";//4个字节
        String s1 = "李子";//4个字节

        System.out.println(s);

        //3、value数组，是一个final类型代表其不可以被修改【内存地址而不是具体字符】
        final char[] values = {'a', 'b','c'};
        values[0] = 'H';//final可以改变字符
        char[] c = {'1','r'};
//        values = c; //不能改变内存地址，final的用法
    }
}
/*
    1、可以注意到String是一个final类，表示他不能被继承
    2、String的本质就是字符串数组
        private final char value[]
    3、一定要注意上面的value数组，是一个final类型代表其不可以被修改【内存地址而不是具体字符】
 */