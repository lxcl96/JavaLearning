package com.ly.tankgame5;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @Author : Ly
 * @Date : 2022/3/23
 * @Description : 坦克游戏主窗口【JFrame】,移动坦克位置
 * @Version : 5.0
 */
public class TankGame05 extends JFrame{
    //定义一个MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        TankGame05 tankGame = new TankGame05();
    }

    public TankGame05() {
//        //获取上一次得分
        Recorder.readScore();
        //选择开始新游戏还是继续游戏
        System.out.println("请输入模式：1 开始新游戏  2 继续游戏");
        Scanner ms = new Scanner(System.in);
        int choice = ms.nextInt();
        if (choice == 1) {
            mp = new MyPanel();
        } else if (choice == 2) {
            mp = new MyPanel(Recorder.readEnemyTanks());
        }

        this.add(mp);//把画笔加载到主程序   【注意不是mp.  不然还找不到错误】
        this.setSize(1300,750);//设置窗口大小
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置程序退出方式
        this.setVisible(true);//窗口是否可视？
        new Thread(mp).start();


        //关闭窗口时，记录下得分
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("游戏结束，记录得分");
                Recorder.scoreRecord();
                System.exit(0);
            }
        });
    }
}
