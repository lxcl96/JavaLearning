package com.ly.tankgame;

import javax.swing.*;

/**
 * @Author : Ly
 * @Date : 2022/3/23
 * @Description : 坦克游戏主窗口【JFrame】
 * @Version : 1.0
 */
public class TankGame01 extends JFrame {
    //定义一个MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();
    }

    public TankGame01() {
        mp = new MyPanel();
        this.add(mp);//把画笔加载到主程序   【注意不是mp.  不然还找不到错误】
        this.setSize(1000,750);//设置窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置程序退出方式
        this.setVisible(true);//窗口是否可视？

    }

}
