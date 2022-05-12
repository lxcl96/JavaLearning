package chapter17_Muti_Threads.synchonized_;

/**
 * @Author : Ly
 * @Date : 2022/3/29
 * @Description : Synchronized线程同步
 */
public class tips {
}
/*
    线程同步机制：
    1、在多线程编程，一些敏感的数据不允许被多个线程同时访问，此时就需要使用同步访问技术，
     保证数据在任何时刻，最多只有一个线程访问，以保证数据的完整性。

    2、也可以这样理解：线程同步，即当有一个线程在对内存进行操作时，其他线程都不可以对这个内存地址进行操作，
     直到该线程完成操作，其他线程可能对该内存地址进行操作。


     实现同步的具体方法：
     1、同步代码块
     synchronized(对象) {//这样就会得到对象的锁，才能操作同步代码
        //需要被同步的代码
     }

     2、synchronized还可以放在方法声明中，表示整个方法 为同步方法
     public synchronized void m(String name) {
        //需要同步的代码
     }

     3、如何理解：就好像上厕所把门关上（上锁），完事后再出来（解锁）
     4、使用synchronized解决售票问题
 */
