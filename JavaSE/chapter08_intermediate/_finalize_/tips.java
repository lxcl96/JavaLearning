package chapter08_intermediate._finalize_;

import java.text.SimpleDateFormat;
import java.util.Date;

public class tips {
    public static void main(String[] args) {
//        Date date = new Date();
        System.out.println(new Date());
        System.out.println(new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

        System.out.println("--------------------------------------");
        Date date = new Date();//获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // 以参数格式 格式化时间
        System.out.println(sdf.format(date));//格式化后时间格式
    }
}
/*
    finalize方法：Finalize_.java
        1、当对象被回收时，系统自动调用该对象的finalize方法，子类可以重写此方法，做一些释放资源的操作。

        2、什么时候回收：当某个对象没有任何引用时，则jvm就认为这个对象是一个垃圾对象，就会使用垃圾回收机制来销毁该对象，在销毁该对象前就会调用finalize方法。

        3、垃圾回收机制的调用，是由系统来绝对的也可以使用System.gc()主动触发垃圾回收机制
 */