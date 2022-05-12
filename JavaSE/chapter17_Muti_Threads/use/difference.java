package chapter17_Muti_Threads.use;

/**
 * @Author : Ly
 * @Date : 2022/3/28
 * @Description :
 */
public class difference {
}
/*

    继承Thread 和 实现Runnable的区别
      1、从java的设计看，通过继承Thread类或者实现Runnable接口来创建线程本质上没有区别，从jdk文档中可以看出Thread类本身就实现了Runnable接口

      2、实现Runnable接口方式更加适合多个线程共享一个资源的情况，并且避免了单继承的限制
 */