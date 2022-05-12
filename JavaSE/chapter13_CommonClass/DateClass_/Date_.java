package chapter13_CommonClass.DateClass_;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_ {
    public static void main(String[] args) throws Exception{
        //获取当前时间
        Date date = new Date();
        System.out.println(date);

        //格式化 SimpleDateFormat 指定格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E");
        System.out.println(simpleDateFormat.format(date));

        //传入毫秒数 来指定时间
        Date d = new Date(-10000);
        Date d2 = new Date(0);
        System.out.println(simpleDateFormat.format(d));
        System.out.println(simpleDateFormat.format(d2));

        //字符串转成Date  以指定格式解析
        String d3 = "2021-01-01 12:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.parse(d3));

    }
}
