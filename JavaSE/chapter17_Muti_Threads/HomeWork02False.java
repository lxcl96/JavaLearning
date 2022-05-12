package chapter17_Muti_Threads;

/**
 * @Author : Ly
 * @Date : 2022/3/29
 * @Description : （1）有2个用户分别从同一个卡上取钱（总额：10000）
 *                （2）每次都取1000，当余额不足就不能取款了，不可出现超支现象
 */
public class HomeWork02False {
    public static void main(String[] args) {
        Withdraw2 w1 = new Withdraw2();
        new Thread(w1).start();
        new Thread(w1).start();
    }
}

//如果此类继承Thread类而且是 new Withdraw().start(); new Withdraw().start();则是两个不同的Withdraw类对象
//  都能取到锁，因为不是同一个对象
class Withdraw2 implements Runnable {
    private int balance = 10000;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            if (balance > 0) {
                //应该先锁再判断，不然肯定会多支取一次
                synchronized (this) {
                    balance -= 1000;
                    System.out.println("用户" + Thread.currentThread().getName() + " 取走1000，剩余" + balance);
                    //锁放在这儿会有问题  为什么？ 因为加锁位置有问题，应该先加锁然后判断
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("已完全支取");
                loop = false;
            }
        }

    }
}