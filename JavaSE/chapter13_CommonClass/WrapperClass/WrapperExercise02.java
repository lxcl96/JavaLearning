package chapter13_CommonClass.WrapperClass;

public class WrapperExercise02 {
    public static void main(String[] args) {

        /*
            我的答案 false  false  false
            实际答案false   true   false
                【2，3区别的根本原因就是int的取值范围为：-128-127
                    2中 1在范围内 就直接返回cache数组中的1
                    3中 128不在范围内 需要new Integer(128) 因为cache数组中没有】
         */
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//两个引用对象 == 用于判断地址是否相同


        Integer m = 1;//关键 Intger m = Integer.valueOf(1),而底层就是返回直接就是1（cache数组）
//        Integer m = Integer.valueOf(1);
        Integer n = 1;
        System.out.println(m == n);

        Integer x = 128;//关键 Intger x = Integer.valueOf(1),而底层就是返回new Integer(128)
//        Integer m = Integer.valueOf(128);
        Integer y = 128;
        System.out.println(x == y);
    }
}
