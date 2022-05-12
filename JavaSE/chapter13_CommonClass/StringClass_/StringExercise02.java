package chapter13_CommonClass.StringClass_;

public class StringExercise02 {
    public static void main(String[] args) {
        String a = "hsp";//开辟常量值字符串“hsp”，假设地址为 c01  【即：a-->c01】
        String b = new String("hsp"); //开辟堆地址d01，堆中再指向c01  【即：b-->d01-->c01】
        System.out.println(a.equals(b));//值相同,true
        System.out.println(a == b);//地址不同,a为c01 b为d01 false

        //intern() 返回常量池中字符串hsp的地址
        System.out.println(a == b.intern());//a的地址c01, b.intern()的地址也为c01  true
        System.out.println(b == b.intern());//b的地址d01, b.intern()的地址也为c01  false
    }
}
