package chapter17_Muti_Threads.use.runnable_;

/**
 * @Author : Ly
 * @Date : 2022/3/28
 * @Description : 每隔1s输出hi，当输出10次后，自动退出。使用Runnable接口实现
 * 【这里是静态代理：即用Thread来运行Runnable的实际任务，不是Runnable直接执行】
 */
public class Runnable01{
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start; 不是继承Thread类，没有这个方法了
        //dog.run();这样不会调用多线程，就是主线程调用

        //归根结底还是调用Thread类的start
        Thread thread = new Thread(dog);//【静态代理模式】 见eaxmpleOfProxy.java
        thread.start();
        System.out.println("thread's name = " + Thread.currentThread().getName());
    }
}

class Dog implements Runnable{
    int times = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hi" + ", thread's name = " + Thread.currentThread().getName());

            if (++times > 10)
                break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}