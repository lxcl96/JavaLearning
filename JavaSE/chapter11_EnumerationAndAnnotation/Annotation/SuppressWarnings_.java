package chapter11_EnumerationAndAnnotation.Annotation;

import java.util.ArrayList;
import java.util.List;

/*
    @SuppressWarnings适用范围：TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE
    类型（就是类），字段，方法，参数，构造器，局部变量

 */
@SuppressWarnings({"all"})
public class SuppressWarnings_ {

    //当我们不希望看到编译器的 黄色警告（提示）用@SuppressWarnings
    //在{""}填入不像显示的警告

    //具体参数可见 https://blog.csdn.net/qq_40437152/article/details/86577194
    @SuppressWarnings({"unchecked", "rawtypes"})  //具体参数看
    public static void main(String[] args) {


        List list = new ArrayList();

        list.add("jack");
        list.add("tom");
        list.add("mary");
        @SuppressWarnings({"unused"})
        int i;
        System.out.println(list.get(1));
    }
}

/*
    @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SuppressWarnings {
    String[] value(); //代表可以传递一个数组进去   {"unchecked", "rawtypes"}
    }

 */