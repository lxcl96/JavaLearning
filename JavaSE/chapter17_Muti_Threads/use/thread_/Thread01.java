package chapter17_Muti_Threads.use.thread_;

/**
 * @Author : Ly
 * @Date : 2022/3/24
 * @Description : （1）编写程序开启一个线程，该线程每隔1秒在控制台输出“喵喵，我是小猫咪”
 *                （2）对上题进行改进，当输出80次后，结束该线程
 *                （3）在控制台Dos下使用JConsole监控线程执行情况，并画出程序示意图
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException{
        //创建Cat对象，可以当做线程使用

        new Cat().run(); //这样用的话就不会开启子线程，因为这样就是主方法main调用的，下面输出的线程名称也会是main


        //Cat cat = new Cat();
        //cat.start();//启动线程，start()会调用run()方法,此处为开启子线程 【start源码解读见Thread_start.java】
        System.out.println("主线程名称：" + Thread.currentThread().getName());//此处是线程main

        //说明：当main线程启动一个子线程 Thread-0，主线程不会阻塞，会继续执行【并行】
        for (int i = 0; i < 60; i++) {
            System.out.println(i);
            Thread.sleep(1000);
        }

    }

}

//1.当一个泪继承了Thread类，该类就可以当作线程使用
//2.我们会重写run方法，使用自己的代码逻辑
//3.run方法是Thread实现了Runnable接口的放啊
class Cat extends Thread {
    int times = 0;
    @Override
    public void run() {
        while (true) {
            //快捷键 ctrl+alt+t
            try {

                System.out.println("子线程名称：" + Thread.currentThread().getName());//此处是线程Thread-0
                //该线程每隔1秒在控制台输出“喵喵，我是小猫咪”
                System.out.println("喵喵，我是小猫咪" + times);
                if (++times > 80) {
                    break;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}