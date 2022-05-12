package chapter17_Muti_Threads.use.runnable_;

/**
 * @Author : Ly
 * @Date : 2022/3/28
 * @Description : 演示静态代理模式
 */
public class eaxmpleOfProxy {
}

//此处的 ThreadProxy类实际就是Thread类，因为我们是在模拟Thread
//
class ThreadProxy implements Runnable {
    private Runnable target = null;//

    public ThreadProxy(Runnable target) {
        this.target = target;
    }
    public void start() {
        start0();//真正实现多线程的方法。
    }
    public void start0() {
        run();
    }

    @Override
    public void run() {
        if (target != null)
            target.run();
    }
}