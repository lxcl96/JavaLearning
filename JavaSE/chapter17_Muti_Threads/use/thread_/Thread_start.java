package chapter17_Muti_Threads.use.thread_;

/**
 * @Author : Ly
 * @Date : 2022/3/24
 * @Description : cat.start()源码解读
 */
public class Thread_start {
}
/*
    cat.start()逻辑
     1.调用public synchronized void start() {}方法
        内部关键方法start0 ，此方法会开启一个子线程
     2.private native void start0();是一个本地方法，是JVM调用的，底层是c/c++实现，
        即实际实现多线程地方法是 start0()

 */