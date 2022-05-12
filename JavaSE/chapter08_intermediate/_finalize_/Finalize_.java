package chapter08_intermediate._finalize_;

public class Finalize_ {
    public static void main(String[] args) {
        Car dudu = new Car("dudu");
//        System.out.println(dudu.getName());

        dudu = null;//没有任何引用，变成了垃圾 gc就会回收【把空间释放出来】
        //没有引用后会自动调用finalize方法，但是不会立即回收因此等到程序结束了才会显示
        //如果要立刻显示，可以主动调用回收机制  就会立即显示（并发finalize方法和下面的语言）
        System.gc();//但是如果系统很忙时，也是没什么用的

        //在回收前 就会调用finalize方法  所以我们可以重写finalize方法加入自己的业务逻辑（如数据库连接，打开的文件）
//        System.out.println(dudu.getName());//dudu已经被回收了  所以没办法访问
        System.out.println("程序结束！");

    }
}
class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    //在对象中重写finalize方法  直接敲finalize有提示回车即可

    @Override
    protected void finalize() throws Throwable {
        System.out.println("销毁汽车name" + name + "__");
        System.out.println("销毁汽车name" + this.name);
        System.out.println("释放一些资源！");
    }
}