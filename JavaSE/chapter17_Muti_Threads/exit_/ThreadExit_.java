package chapter17_Muti_Threads.exit_;

/**
 * @Author : Ly
 * @Date : 2022/3/28
 * @Description : 启动一个线程t，要求在main线程中去停止线程t
 */
public class ThreadExit_{
    public static void main(String[] args) throws Exception{
        T t = new T();
        t.start();//t线程不会终止

        //通过改变循环条件，让程序结束 从而代码终止
        Thread.sleep(10 * 1000);
        t.setLoop(false);
    }
}
class T extends Thread {
    int count = 0;
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T Thread 运行中。。。" + (count++));
        }
    }
}