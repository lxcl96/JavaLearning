package chapter17_Muti_Threads.synchonized_;

/**
 * @Author : Ly
 * @Date : 2022/3/29
 * @Description : 模拟线程死锁
 */
public class DeadLock_ {
    public static void main(String[] args) {
        new DeadLockDemo(true).start();
        new DeadLockDemo(false).start();
    }
}


class DeadLockDemo extends Thread {
   static Object o1 = new Object();//使用static 保证多线程公用一个对象
   static Object o2 = new Object();
   boolean flag;

   public DeadLockDemo(boolean flag) {
       this.flag = flag;
   }

    @Override
    public void run() {
        //如果为真，先拿到o1的锁，然后去拿o2的锁
        //如果为假，先拿到o2的锁，然后去拿o1的锁
        //如果同时执行真假两个代码就会死锁
        if (flag) {
            synchronized (o1) { //同步就是加上对象互斥锁，【o1就是对象互斥锁，下面的代码就是同步代码】
                System.out.println(Thread.currentThread().getName() + "进入 1");
                try {
                    Thread.sleep(10);//时间差
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "进入 2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "进入 2");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "进入 1");
                }
            }
        }
    }
}
