package chapter17_Muti_Threads.TicketsSystem;

/**
 * @Author : Ly
 * @Date : 2022/3/28
 * @Description : 使用多线程，模拟三个窗口同时售票
 */
public class SellTickets {
    public static void main(String[] args) {
        //创建3个对象，同时售票
//        SellTickets01 sellTickets01 = new SellTickets01();
//        SellTickets01 sellTickets02 = new SellTickets01();
//        SellTickets01 sellTickets03 = new SellTickets01();
//
//        sellTickets01.start();
//        sellTickets02.start();
//        sellTickets03.start();
        //创建一个对象，同时售票
        SellTickets02 sellTickets = new SellTickets02();
        new Thread(sellTickets).start();
        new Thread(sellTickets).start();
        new Thread(sellTickets).start();
    }
}

//使用Thread方式 【会出现线程不同步问题】
class SellTickets01 extends Thread {
    private static int ticketNum = 100;//多个线程共享 ticketNum 加不加static都会出错]

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束。。。");
                break;
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
}

//实现Runnable接口方式
class SellTickets02 implements Runnable {
    private int ticketNum = 100;//多个线程共享 ticketNum [因为只创建一个SellTickets02类对象，所以用不用static都可以]

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束。。。");
                break;
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

}