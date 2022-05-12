package chapter13_CommonClass.StringClass_;

public class StringExercise08 {
    public static void main(String[] args) {
        String a = "hello";
        String b = "abc";

        /**
         * 执行的步骤为:
         * 1.先创建一个StringBulider  StringBuilder sb = new StringBuilder()
         * 2.执行sb.append("hello") 把hello添加到sb中
         * 3.执行sb.append("abc") 把abc添加到sb中
         * 4.调用StringBuilder的toString方法重新创建一个String(value) 并返回给c String c = new String(value,0,count)
         *    其中value[] = helloabc 0代表起始位置 count代表长度为8
         *///最后就是c执行堆中的对象(String) ,其中value[]再指向常量池中的 helloabc
        String c = a + b;
        /*
            问:一共创建了几个对象?
                我的答案:3个 [开辟一个堆对象String,c执行它,String的value[]执行hello和abc]
                实际是:3个
         */

        //进阶题目
        String d = "helloabc";
        System.out.println(c == d);//结果为false
        /*
            原因:看内存图就知道了
         */
        String e = "hello" + "abc";
        System.out.println(e == d);//true
    }
}
