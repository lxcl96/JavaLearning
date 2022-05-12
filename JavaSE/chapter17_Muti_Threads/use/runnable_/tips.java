package chapter17_Muti_Threads.use.runnable_;

/**
 * @Author : Ly
 * @Date : 2022/3/28
 * @Description :
 */
public class tips {
}
/*
    使用Runnable接口实现线程：
        1、java是单继承的，在某些情况下一个类可能已经继承了某个父类，这时候再用继承Thread类的方法
            来创建线程显然不可能了
        2、java设计者们提供了另外一个方式创建线程，就是通过实现Runnable接口来创建线程
   */