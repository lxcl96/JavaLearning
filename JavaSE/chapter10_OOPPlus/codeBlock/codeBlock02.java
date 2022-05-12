package chapter10_OOPPlus.codeBlock;

public class
codeBlock02 {
    public static void main(String[] args) {
        //而且先 调用静态代码块
        T t1 = new T();
        // 第二次实例化 静态代码块就不会再被调用了
        T t2 = new T();
    }
}

class T {

    {
        System.out.println("这个是非静态代码块，每创建一个对象时就会被调用");
        System.out.println("++++++++++++++++++");
    }

    static {
        System.out.println("这个是静态代码块，只会在第一次加载时被调用");
        System.out.println("------------------");
    }


}