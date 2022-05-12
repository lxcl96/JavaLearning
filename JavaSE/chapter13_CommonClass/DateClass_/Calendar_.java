package chapter13_CommonClass.DateClass_;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calendar_ {
    public static void main(String[] args) {
        /*
            Calendar的构造器是private因此不能new，但是可以使用getInstance获取实例
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar c = Calendar.getInstance();
        System.out.println(c.toString().replace(',','\n'));
        System.out.println(sdf.format(c.getTime()));
        System.out.println("使用get方法获取属性才是对的，直接输出是不对的");
        System.out.println("年" + c.get(Calendar.YEAR));
        System.out.println("月" + c.get(Calendar.MONTH)); //月要+1 因为是从0开始的
        System.out.println("日" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("时" + c.get(Calendar.HOUR));//12小时进制
        System.out.println("时" + c.get(Calendar.HOUR_OF_DAY));//24小时进制
        System.out.println("分" + c.get(Calendar.MINUTE));
        System.out.println("秒" + c.get(Calendar.SECOND));

        //没有指定格式化方法，可以自己组合 更方便
    }
}
