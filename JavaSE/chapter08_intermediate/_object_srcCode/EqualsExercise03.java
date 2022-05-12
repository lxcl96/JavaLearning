package chapter08_intermediate._object_srcCode;



public class EqualsExercise03 {
    public static void main(String[] args) {
        //  equals判断
        int it = 65;
        float fl = 65.0f;
        System.out.println(it == fl);//true
        char ch1 = 'A';
        char ch2 = 12;

        System.out.println(it == ch1);//true
        System.out.println(12 == ch2);//true

        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1 == str2);//false
        System.out.println(str1.equals(str2));//true
//        System.out.println("hello" == new java.sql.Date()); //fasle  编译器就报错了

    }
}
