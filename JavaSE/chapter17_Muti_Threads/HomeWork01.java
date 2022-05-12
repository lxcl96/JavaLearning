package chapter17_Muti_Threads;

import java.util.Scanner;

/**
 * @Author : Ly
 * @Date : 2022/3/29
 * @Description :
 */
public class HomeWork01 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        Input input = new Input();

        t1.start();
        //input.setDaemon(true);
        input.start();

    }
}

class T1 extends Thread {

    @Override
    public void run() {
        while (Input.loop) {
            System.out.println((int) (Math.random() * 100));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //不能在这里 不然每执行一次都会创建一个线程，
//            Input input = new Input();
//            input.setDaemon(true);
//            input.start();
//            if ("Q".equals(input.getOrder())) {
//                loop = false;
//            }
        }
    }
}

class Input extends Thread {
    public static boolean loop = true;

    @Override
    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if ("Q".equals(scanner.next())) {
                loop = false;
                break;
            }
            System.out.println(scanner.next());
        }
    }
}