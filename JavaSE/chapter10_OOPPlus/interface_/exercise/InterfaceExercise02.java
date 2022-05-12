package chapter10_OOPPlus.interface_.exercise;

public class InterfaceExercise02 {

}
interface AA {
    int x = 0;//等价于public static final int x = 0;
}
class BB {
    int x = 1;
}

//我的回答是 没报错
class CC extends BB implements AA {

    public void pX() {
        //实际上编译器也不知道找哪个，重复了 所以需要特意指明是那个x
//        System.out.println(x);
        System.out.println(AA.x);//使用AA的x
        System.out.println(super.x);//使用BB的x
    }

    public static void main(String[] args) {
        new CC().pX();
    }
}