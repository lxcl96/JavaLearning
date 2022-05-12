package chapter17_Muti_Threads.use;

/**
 * @Author : Ly
 * @Date : 2022/3/28
 * @Description : 多线程 一个每隔1s输出hello 输出10次退出；一个每隔1s输出hi，输出5次退出 【要求使用Runnable接口】
 */
public class Thread03 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        new Thread(t1).start();
        new Thread(t2).start();
    }
}
class T1 implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello world" + Thread.currentThread().getName());
            if (++count ==10)
                break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class T2 implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hi, " + Thread.currentThread().getName());
            if (++count == 5)
                break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}