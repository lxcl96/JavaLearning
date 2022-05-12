package chapter13_CommonClass.BigNumber;


import java.math.BigDecimal;

public class BigDecimal_ {
    public static void main(String[] args) {
        //这个是针对小数的  保存精度很高的
        double n = 15515.89999990000000000000001111111111111111111111111111111111000000000033333333333333333333333333333333333333333333330000000001544d;
        System.out.println(n);


        //以字符串形式保存
        BigDecimal bigDecimal = new BigDecimal("15515.8999999000000000000000111111111111111111111111111111111100000000003333333333333333333333333333");
        System.out.println(bigDecimal);
        BigDecimal div = new BigDecimal("3");
        //加减乘除也都需要使用指定方法
        //除法可能会抛出异常,因为有可能除不尽 所以需要指定精度
        //              BigDecimal.ROUND_CEILING就是指 保留 和被除数的小数点位数一样
        System.out.println(bigDecimal.divide(div, BigDecimal.ROUND_CEILING));
        System.out.println(bigDecimal.divide(div, 3));
    }
}
