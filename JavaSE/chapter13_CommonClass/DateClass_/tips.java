package chapter13_CommonClass.DateClass_;

public class tips {

}
/*
    Java中存在三种日期类:Date、calendar、LocalDate
    1、Date 精确到毫秒（ms），代表特定的瞬间  【参考：Date_.java】
        配套使用类：SimpleDateFormat：
            格式化（日期-->文本）和
            解析日期（文本-->日期）的类

    2、Calendar类是一个抽象类，它为特定瞬间与一组诸如YEAR、MONTH、DAT_OF_MONTH、HOUR等日历字段之间的转换提供方法
        也为操作日历 字段（例如获得下星期的日期）提供方法  【参考：Calendar_.java】


    3、LocalDate:分为LocalDate、LocalTime、LocalDateTime三类
        Date和Calendar存在的问题：     【参考：LocalDate_.java】
            ①、可变性：像日期和时间这种类型应该是不可变的
            ②、偏移性：Date中年份是从1900开始的，而月份都是从0开始的
            ③、格式化：格式化只对Date有用，对Calendar无用
            ④、这两个线程都不安全，不能处理闰秒（即每隔两年会多出1s）

 */