package chapter13_CommonClass.StringClass_;

public class String02 {
    public static void main(String[] args) {
        //1、方式一：先从常量池中查看是否有"Hello" 的数据空间,如果有,则直接指向;如果没有则重新创建,然后指向.
        String s1 = "hello";
        System.out.println(s1.hashCode());

        String s2 = "hello";
        System.out.println(s2.hashCode());//s2和s1的地址一样,如果改变s1地址上的值,s2的值也会改变

        String s3 = "hello";
        System.out.println(s3.intern());

        final char[] ch = {'j', 'a', 'v', 'a'};
        System.out.println(ch);
    }
}
