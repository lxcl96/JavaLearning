package chapter17_Muti_Threads.ThreadMethods;

/**
 * @Author : Ly
 * @Date : 2022/3/28
 * @Description :
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("hi 主");

            if (i == 4) {
                //线程插队 一定会成功
                //t1.join();//插入t1，让t1先执行。等t1执行完再继续执行main

                //线程的礼让 不一定会成功
                Thread.yield();
            }
            Thread.sleep(1000);
        }
    }
}

class T1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("hello 子");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}