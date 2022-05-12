package com.ly.tankgame5;

import java.util.Vector;

/**
 * @Author : Ly
 * @Date : 2022/3/23
 * @Description : 我的坦克
 */
public class MyTank extends Tank {
    //定义一个子弹对象，此时仅可以发射一颗子弹
    Bullet bullet = null;
    //定义一个子弹集合，可以发射多颗子弹
    Vector<Bullet> bulletsList= new Vector<>();

    public MyTank(int x, int y, int direct) {
        super(x, y, direct);
    }

    //我们坦克的设射击方法
    public void shot() {
        //基于炮筒的位置创建子弹 【最好不要在MyPanel中制定，因为那是画出】
        switch (super.getDirect()) {
            case 0://向上
                bullet = new Bullet(super.getX() + 20, super.getY(), 0);
                break;
            case 1://向右
                bullet = new Bullet(super.getX() + 60, super.getY() + 20, 1);
                break;
            case 2://向下
                bullet = new Bullet(super.getX() + 20, super.getY() + 60, 2);
                break;
            case 3://向左
                bullet = new Bullet(super.getX(), super.getY() + 20, 3);
                break;
        }

        //最优解 在此处讲子弹加入到子弹集合中
        this.bulletsList.add(bullet);
        //System.out.println("子弹开始运行");
        new Thread(bullet).start();
    }
}
