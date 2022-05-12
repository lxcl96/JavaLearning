package chapter08_intermediate.encapsulation;

public class Tips {
    public static void main(String[] args) {

    }
}
/*
        encapsulation（encap/封装）：就是把抽象出的 数据【属性】和对数据的操作【方法】 封装在一起，数据被保护在内部，
    程序的其它部分只能通过 被授权的操作【方法】 才能对数据进行操作。

    封装的步骤：
     1、将属性进行私有化private，不能直接修改属性。
     2、提供一个公共的set方法，用于对属性判断并赋值
     public void setXxx(类型 参数名) {
        //加入数据验证的业务逻辑
        属性名 = 参数名；
     }
     3、提供一个公共的get方法，用于获取属性的值
     public XX getXxx{
        //权限判断
        return xx;
     }
 */