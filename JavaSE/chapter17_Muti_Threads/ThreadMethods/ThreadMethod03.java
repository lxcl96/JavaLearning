package chapter17_Muti_Threads.ThreadMethods;

/**
 * @Author : Ly
 * @Date : 2022/3/29
 * @Description : 测试如何将一个线程设置为守护线程
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //如何实现main进程结束，MyDaemonThread类进程也会结束呢？
        //  方式是将MyDaemonThread类进程设置为守护线程即可
        //守护线程当所有的用户线程
        myDaemonThread.setDaemon(true); //必须调用前声明
        myDaemonThread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("宝强在辛苦的拍电影。。");
            Thread.sleep(1000);
        }
    }
}


class MyDaemonThread extends Thread {//我的守护线程
    @Override
    public void run() {
       for (; ;) {//无限循环
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("马蓉和宋喆快乐聊天，哈哈哈哈~~~~");
       }
    }
}