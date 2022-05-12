package chapter11_EnumerationAndAnnotation.Enumeration;

public class EnumerationExercise01 {
    public static void main(String[] args) {
        Gender boy = Gender.BOY;
        Gender boy2 = Gender.BOY;

        //枚举值分两个key：value  所以
        System.out.println(boy);//输出Enmu类的name即枚举对象名
        System.out.println(boy == boy2);
//        Enum;


        A a = A.instance;
        System.out.println(a);//Enum的toString只输出Key-value的key 所以如果想要把值都输出来，需要自定义toString方法

    }


}
enum Gender {
    BOY,GIRL;
}


enum A{
    instance(200);
    private int n1;

    A(int n1) {
        this.n1 = n1;
    }

//    @Override
//    public String toString() {
//        return "A{" +
//                "n1=" + n1 +
//                '}';
//    }
}