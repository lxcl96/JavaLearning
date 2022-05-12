package chapter13_CommonClass.BigNumber;

import java.math.BigInteger;

public class BigInteger_ {
    public static void main(String[] args) {
        //解决超长数据问题  如111111111111111111111111111111111
//        long n = 1111111111111111111111l;
        BigInteger bigInteger = new BigInteger("1111111111111111111111");
        System.out.println(bigInteger);
        //进行加减乘除 必须使用方法不能使用 符号+-*/ 而且必须是同类型的 BigInteger类型
        System.out.println(bigInteger.add(new BigInteger("1")));
    }
}
