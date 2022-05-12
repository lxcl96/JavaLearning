package chapter13_CommonClass.StringBuffer_;

public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//看源码，把null空对象当转成字符串null存进来了
        System.out.println(sb.length());//0 实际答案是4
        /*
            需要注意：
                String s1 = null;
                String s2 = "";
                s1是空对象，没存放地址，s1.length()会报错
                s2不是空对象，存放地址，s2.length()是0
         */
        System.out.println(sb);//null
        StringBuffer sb1 = new StringBuffer(str);//放入空值，直接报空指针异常
        System.out.println(sb1);


        String s1 = null;
        String s2 = "";
        System.out.println(s2.length());
    }
}
