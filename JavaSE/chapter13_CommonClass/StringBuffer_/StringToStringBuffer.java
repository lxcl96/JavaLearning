package chapter13_CommonClass.StringBuffer_;

public class StringToStringBuffer {
    public static void main(String[] args) {
        //String ---> StringBuffer
        String s = "hello";
        //方法1. s本身不影响，影响的是b1
        StringBuffer b1 = new StringBuffer(s);
        //方法2. s本身不影响，影响的是b2
        StringBuffer b2 = new StringBuffer();
        b2.append(s);

        //StringBuffer ---> String
        StringBuffer s1 = new StringBuffer("hello");
        //方法1.
        String c1 = new String(s1);
        //方法2. 使用toString()
        String c2 = s1.toString();


    }
}
