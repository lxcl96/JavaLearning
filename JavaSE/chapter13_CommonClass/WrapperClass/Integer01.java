package chapter13_CommonClass.WrapperClass;

public class Integer01 {
    public static void main(String[] args) {
        //演示int <---> Integer的装箱和拆箱

        //1.5 之前的 手动装箱
        int n1 = 100;
        Integer integer = new Integer(n1);//第一种方法
        Integer integer1 = Integer.valueOf(n1);//第二种方法
        //1.5 之前的 手动拆箱
        int i = integer.intValue();
        System.out.println(integer);


        //1.5和之后 自动装箱
        int n2 = 200;
        Integer integer2 = n2; //自动转换 底层使用的依然是 Integer.valueOf(n2) 可debug查看
        //1.5和之后 自动拆箱
        int j = integer2;//自动转换 底层使用的依然是 integer.intValue() 可debug查看


    }
}
