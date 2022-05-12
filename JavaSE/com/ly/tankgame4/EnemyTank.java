package com.ly.tankgame4;

import java.util.Vector;

/**
 * @Author : Ly
 * @Date : 2022/3/23
 * @Description : 敌人坦克
 */
public class EnemyTank extends Tank implements Runnable{
    Vector<Bullet> bulletsList = new Vector<>();//存放多个子弹变量
    boolean isLive = true;
    public EnemyTank(int x, int y, int direct) {
        super(x, y, direct);
    }

    @Override
    public void run() {
        //System.out.println("敌人坦克线程 " + Thread.currentThread().getName() + "已经启动！");
        while (true) {
            //根据坦克的方向 继续移动
            switch (super.getDirect()) {
                case 0:
                    //让坦克在同一个方向上走出30步
                    for (int i = 0; i < 30; i++) {
                        //防止越界
                        if (super.getY() > 0) {
                            super.moveUp();
                        }

                        //休眠一下
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    //让坦克在同一个方向上走出30步
                    for (int i = 0; i < 30; i++) {
                        if (super.getX() + 60 < 1000) {
                            super.moveRight();
                        }

                        //休眠一下
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    //让坦克在同一个方向上走出30步
                    for (int i = 0; i < 30; i++) {
                        if (super.getY() + 60 < 750) {
                            super.moveDown();
                        }

                        //休眠一下
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    //让坦克在同一个方向上走出30步
                    for (int i = 0; i < 30; i++) {
                        if (super.getX() > 0) {
                            super.moveLeft();
                        }

                        //休眠一下
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

            }

            //随机改坦克方向
            super.setDirect((int) (Math.random() * 4));


            //线程一定要考虑啥时候退出，否则内存一点点占用
            if (!isLive) {
                break;
            }
        }

        //System.out.println("敌人坦克线程 " + Thread.currentThread().getName() + "已经退出了");
    }

    //因为现在坦克只向下，所以不考虑别的方向子弹，放在MyPanel中初始化EnemyTank时创建

}
