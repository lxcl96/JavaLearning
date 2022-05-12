package com.ly.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @Author : Ly
 * @Date : 2022/3/23
 * @Description : 画板，用于绘制图形
 */
public class MyPanel extends JPanel{
    //定义我的坦克
    MyTank hero = null;
    public MyPanel() {
        hero = new MyTank(100,100);//初始化自己的坦克 [横纵坐标]
    }

    //继承画笔 用于绘图

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形

        //画出坦克-封装方法
        drawTank(hero.getX(),hero.getY(),g,0,0);
    }

    /**
     *
     * @param x 坦克的左上角坐标
     * @param y 坦克的左上角坐标
     * @param g 画笔
     * @param direct  方向 【0：向上的】
     * @param type  坦克类型 【1：我们的坦克，0：敌人的坦克】
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);//我们的：青色
                break;
            case 1:
                g.setColor(Color.yellow);//敌人的：黄色
        }

        //根据坦克的方向绘制坦克
        switch (direct) {
            case 0:
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x + 30,y,10,60,false);
                g.fill3DRect(x + 10,y + 10,20,40,false);
                g.fillOval(x + 10,y + 20,20,20);
                g.drawLine(x + 20,y + 30, x + 20, y);
                break;
            default:
                System.out.println("其他的暂时不做处理");
        }
    }


}


