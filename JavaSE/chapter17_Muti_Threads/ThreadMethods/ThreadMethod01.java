package chapter17_Muti_Threads.ThreadMethods;

/**
 * @Author : Ly
 * @Date : 2022/3/28
 * @Description :
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws Exception{
        T t = new T();

        t.start();
        Thread.sleep(100);
        t.setName("猪咪~ ");
        //t.setPriority(Thread.MIN_PRIORITY);
        Thread.sleep(10000);
        t.interrupt();//中断  根据代码而定，只会提前下一轮循环 此代码中
    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " 吃包子~~~~" + i);
            }

            try {
                System.out.println(Thread.currentThread().getName() + " 休眠中~~~");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                //中断线程，走下面的继续处理。不是中断线程
                System.out.println(Thread.currentThread().getName() + " 被interrupt了");
            }
        }
    }
}