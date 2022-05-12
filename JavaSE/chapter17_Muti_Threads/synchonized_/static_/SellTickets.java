package chapter17_Muti_Threads.synchonized_.static_;

/**
 * @Author : Ly
 * @Date : 2022/3/28
 * @Description : 使用多线程，模拟三个窗口同时售票
 */
public class SellTickets {
    public static void main(String[] args) {
        //创建一个对象，同时售票
        SellTickets04 sellTickets = new SellTickets04();
        SellTickets04 sellTickets01 = new SellTickets04();
        //三个线程操作的是同一个对象，所以this可以换成obj，因为是一个对象开启了三个线程
        new Thread(sellTickets).start();
        new Thread(sellTickets).start();
        new Thread(sellTickets).start();
        new Thread(sellTickets01).start();//就不是同一个对象了，但是如果sell方法为静态同步方法，此时锁就加载当前类本身上了。所以四个线程会同步
    }
}

//实现Runnable接口方式  使用 同步代码块 synchronized实现线程同步
class SellTickets04 implements Runnable {
    private static int ticketNum = 100;//多个线程共享 ticketNum [因为只创建一个SellTickets02类对象，所以用不用static都可以]
    static Object obj = new Object();
    //同步代码块 这个锁是加在this对象上的 ，当然可以是其他对象，但要是同一个对象
    //       【如果此方法为静态方法，则锁是加载当当前类SellTickets04本身上】
    public static void sell() {//同一时刻只能有一个县线程来操作
        //***【如果在静态代码中想使用this 需要换成‘ 类名.class’，this不好使了】
        synchronized (SellTickets04.class) {//三个线程操作的是同一个对象，所以类名.class可以换成obj，因为是一个对象开启了三个线程
            if (ticketNum <= 0) {
                System.out.println("售票结束。。。");
                //return;
                System.exit(0);
            }


            //休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));
        }
    }

    @Override
    public void run() {//如果把此方法变成synchronized方法，则多线程失效，总是只有一个线程运行
        while (true) {
            sell();
        }
    }

}