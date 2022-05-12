package chapter17_Muti_Threads.ThreadMethods;

/**
 * @Author : Ly
 * @Date : 2022/3/28
 * @Description :
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();

        for (int i = 1; i <= 10; i++) {
            System.out.println("主 hi  " + i);

            if (i == 5) {
                Thread thread = new Thread(t2);
                thread.start();
                thread.join();
            }

            Thread.sleep(1000);

        }
        System.out.println("主线程结束。。。");
    }
}


class T2 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("子 hello " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("子线程结束。。。");
    }
}