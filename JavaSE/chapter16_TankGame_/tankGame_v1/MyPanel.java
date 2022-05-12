package chapter16_TankGame_.tankGame_v1;

import javax.swing.*;
import java.awt.*;

/**
 * @FileName:MyPanel.class
 * @Author:ly
 * @Date:2022/3/14
 * @Description:画板，画出图形 【我的坦克】
 */
public class MyPanel extends JPanel {
    //画出我的坦克
    Hero hero = null;//

    public MyPanel() {
        hero = new Hero(100, 100);//初始位置
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0,1000,750);

        //画出坦克-封装方法
        drawTank(hero.getX(), hero.getY(), g,0, 0);
    }

    /**
     *
     * @param x 坦克左上角x轴坐标
     * @param y 坦克左上角y轴坐标
     * @param g 画笔，用来画
     * @param direct 坦克移动方向【上下左右】
     * @param type 类型【0：自己的， 1：敌人的】
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type ) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }

        //根据不同的方向 画坦克
        switch (direct) {
            case 0://向上
                g.fill3DRect(x, y,10, 60, false);//左轮子
                g.fill3DRect(x + 30, y,10, 60, false);//右轮子
                g.fill3DRect(x + 10, y + 10,20, 40, false);//中间
                g.fillOval(x + 10, y + 20,20, 20);//轮子
                g.drawLine(x + 20, y + 30,x + 20, y);//炮筒
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
