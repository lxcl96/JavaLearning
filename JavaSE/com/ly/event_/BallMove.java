package com.ly.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @Author : Ly
 * @Date : 2022/3/23
 * @Description : 通过操纵小球，熟悉方向移动事件
 */
public class BallMove extends JFrame{
    MyPanel mp = null;
    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.addKeyListener(mp);//监听mp的键盘操作
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}

//画出小球
//通过监听键盘事件，实现操作
class MyPanel extends JPanel implements KeyListener {

    //为了让小球能够移动，所以需要将小球左上角的坐标设置为变量 【即：在下个位置重新绘制小球】
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);//画出小球
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println((char)e.getKeyCode());
        //根据用户按下的建 进行移动
        if (e.getKeyCode() == KeyEvent.VK_S) {
            //s 下移
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            //w 上移
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            //a 左
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            //d 右移
            x++;
        }
        //改变坐标后需要重新绘制 坦克
        this.repaint();//或者repaint(),不过加this更容易理解
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}