package chapter10_OOPPlus.final_;

public class finalDetail03 {
    public static void main(String[] args) {
        BB bb = new BB();
        //不能重写final方法，但是继承了该方法
        bb.print();
    }
}

class AA{
    public final void print() {
        System.out.println("哈哈");
    }
}

class BB extends AA {
    //不能重写final方法，但是继承了该方法
//    public final void print() {
//        System.out.println("哈哈");
//    }

}

