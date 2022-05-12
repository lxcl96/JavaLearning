package chapter17_Muti_Threads.synchonized_;

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
        //static方法的话 详见static报下同类【此时锁加载当前类本身】 等同于new SellTickets04().start();
        new Thread(sellTickets01).start();//就不是同一个对象了，但是如果sell方法为静态同步方法，此时锁就加载当前类本身上了。所以四个线程会同步
    }
}

//实现Runnable接口方式  使用 同步方法 synchronized实现线程同步
class SellTickets03 implements Runnable {
    private int ticketNum = 100;//多个线程共享 ticketNum [因为只创建一个SellTickets02类对象，所以用不用static都可以]

    //同步方法 这时锁加在this对象上 【如果此方法为静态方法，则锁是加载当当前类SellTickets03本身上】
    public synchronized void sell() {//同一时刻只能有一个县线程来操作
        if (ticketNum <= 0) {
            System.out.println("售票结束。。。");
            //return;
            System.exit(0);
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                + " 剩余票数=" + (--ticketNum));
    }

    @Override
    public void run() {//如果把此方法变成synchronized方法，则多线程失效，总是只有一个线程运行
        while (true) {
            sell();
        }
    }

}

//实现Runnable接口方式  使用 同步代码块 synchronized实现线程同步
class SellTickets04 implements Runnable {
    private int ticketNum = 100;//多个线程共享 ticketNum [因为只创建一个SellTickets02类对象，所以用不用static都可以]
    Object obj = new Object();
    //同步代码块 这个锁是加在this对象上的 ，当然可以是其他对象，但要是同一个对象
    //       【如果此方法为静态方法，则锁是加载当当前类SellTickets04本身上】
    public void sell() {//同一时刻只能有一个县线程来操作
        synchronized (obj) {//三个线程操作的是同一个对象，所以this可以换成obj，因为是一个对象开启了三个线程
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