package chapter08_intermediate._object_srcCode;



public class EqualsExercise02 {
    public static void main(String[] args) {
        A a = new A();
        a.name = "ly";
        A a1 = new A();
        a1.name = "ly";
        System.out.println(a == a1);//false
        System.out.println(a.name.equals(a1.name));//true
        System.out.println(a.equals(a1));//false //A类中没有重写equals 因此调用的是Object的equals方法，比较地址

        String b = new String("tom");
        String b1 = new String("tom");
        System.out.println(b == b1);//false

        //*************** kankan对象是否把它重写了
        System.out.println(b.equals(b1));//false 但是实际答案是 true 因为String这个对象重写了equals，用来比较其值是否相同


    }
}


class A {
    public String name;
}