package chapter13_CommonClass.DateClass_;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class LocalDate_ {
    public static void main(String[] args) {

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        //声明方法不是正常的 new LocalDateTime(); 而是调用LocalDateTime.now()相当于getInstance吧
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        //now.format()需要一个DateTimeFormatter参数带入格式化类型
        /*
            【都是静态方法，返回类相当于getInstance吧】
            获取时间
                LocalDateTime now = LocalDateTime.now();
             获取格式
                DateTimeFormatter fo = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

         */
        DateTimeFormatter fo = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(now.format(fo));



        //时间戳：Instance 类似于Date 是属于Instance类的
        Instant now1 = Instant.now();//等同于new Date()
        System.out.println(now1 + "   " + new Date());

        //Insatnce 转成 Date
        Date f1 = Date.from(now1);
        System.out.println(f1);

        //Date 转 Instance
        Instant instant = f1.toInstant();
        System.out.println(instant);

        //使用plus 和 minus方法可以对当前时间进行加或减
        //如看890天后的具体时分秒
        LocalDateTime ld = now.plusDays(890);
        System.out.println(fo.format(ld));

        LocalDateTime ld2 = now.minusDays(890);
        System.out.println(ld2.format(fo));

    }
}
