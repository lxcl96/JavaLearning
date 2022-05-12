package chapter13_CommonClass.WrapperClass;

public class WrapperVSString {
    public static void main(String[] args) {
        //包装类转成 （以Integer为例）--String
        Integer n1 = 100;
        //方法1： + ""
        String s1 = n1 + "";//这样做 n1本身没有发生变化
        System.out.println(s1);
        //方式2：toString()
        String s2 = n1.toString();
        //方式3:String.valueOf(n1)
        String s3 = String.valueOf(n1);


        //String 转成 包装类 String -- Integer
        //方式1：包装类.valueOf()
        Integer n2 = Integer.valueOf(s2);
        //方法2：包装类.parse数据类型 如：Integer.parseInt()
        Integer n3 = Integer.parseInt(s2);//返回int，然后自动装箱
        //方法3：构造器中可以传递字符串
        Integer integer = new Integer(s2);
//        Character


    }
}
