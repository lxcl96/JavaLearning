//package com.ly.tankgame4_my;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.util.Vector;
//
///**
// * @Author : Ly
// * @Date : 2022/3/23
// * @Description : 画板，用于绘制图形
// */
////KeyListener 监听键盘
//public class MyPanel extends JPanel implements KeyListener, Runnable{
//    //定义我的坦克
//    MyTank hero = null;
//    //定义敌人的坦克  放到Vector集合中
//    Vector<EnemyTank> enemyTanks = new Vector<>();
//    //初始化敌人坦克数量
//    int enemyTankSize = 3;
//
//    public MyPanel() {
//        hero = new MyTank(100,100, 0);//初始化自己的坦克 [横纵坐标]
//
//        //初始化敌人的坦克
//        for (int i = 0; i < enemyTankSize; i++) {
//            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0, 2);
//            enemyTanks.add(enemyTank);//先初始化对象，然后再是画图形
//            Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
//            //把子弹加入敌人坦克下的子弹数组
//            enemyTank.bulletsList.add(bullet);
//            //启动该子弹线程
//            new Thread(bullet).start();
//        }
//
//    }
//
//    //继承画笔 用于绘图
//
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        g.fillRect(0,0,1000,750);//填充矩形
//
//        //画出坦克-封装方法
//        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),1);
//
//        //画出敌人的坦克  遍历Vector集合
//        for (EnemyTank enemy:enemyTanks) {
//            drawTank(enemy.getX(),enemy.getY(),g,enemy.getDirect(),0);
//        }
//
//    }
//
//    @Override
//    public void run() {
//        Bullet b = hero.bullet;
//        //画出子弹
//        while ((b != null) && b.isLive ) {
//            drawBullet(b.x,b.y,super.getGraphics(),b.direct,1);
//            super.repaint();
//        }
//
//        //画出敌人的坦克 【就是要死循环画】 遍历Vector集合
//        while (true) {
//            try {
//                for (EnemyTank enemy:enemyTanks) {
//                    //取出每个坦克的子弹集合
//                    for (Bullet bullet_enemy:enemy.bulletsList) {
//                        if (bullet_enemy.isLive) {
//                            drawBullet(bullet_enemy.x,bullet_enemy.y,super.getGraphics(),bullet_enemy.direct,0);
//                        } else {
//                            enemy.bulletsList.remove(bullet_enemy);//如果子弹失效，就要从里面移除掉
//                        }
//                        this.repaint();
//                    }
//                }
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
//
//        //System.out.println(Thread.currentThread().getName() + "结束，停止绘图");
//    }
//
//    /**
//     *
//     * @param x 坦克的左上角坐标
//     * @param y 坦克的左上角坐标
//     * @param g 画笔
//     * @param direct  方向 【0：向上，1：向右，2：向下，3：向左】
//     * @param type  坦克类型 【1：我们的坦克，0：敌人的坦克】
//     */
//    public void drawTank(int x, int y, Graphics g, int direct, int type) {
//        switch (type) {
//            case 0:
//                g.setColor(Color.cyan);//我们的：青色
//                break;
//            case 1:
//                g.setColor(Color.yellow);//敌人的：黄色
//        }
//
//        //根据坦克的方向绘制坦克
//        switch (direct) {
//            case 0://向上
//                g.fill3DRect(x,y,10,60,false);
//                g.fill3DRect(x + 30,y,10,60,false);
//                g.fill3DRect(x + 10,y + 10,20,40,false);
//                g.fillOval(x + 10,y + 20,20,20);
//                g.drawLine(x + 20,y + 30, x + 20, y);
//                break;
//            case 1://向右
//                g.fill3DRect(x,y,60,10,false);
//                g.fill3DRect(x,y + 30,60,10,false);
//                g.fill3DRect(x + 10,y + 10,40,20,false);
//                g.fillOval(x + 20,y + 10,20,20);
//                g.drawLine(x + 30,y + 20, x + 60, y + 20);
//                break;
//            case 2://向下
//                g.fill3DRect(x,y,10,60,false);
//                g.fill3DRect(x + 30,y,10,60,false);
//                g.fill3DRect(x + 10,y + 10,20,40,false);
//                g.fillOval(x + 10,y + 20,20,20);
//                g.drawLine(x + 20,y + 30, x + 20, y + 60);
//                break;
//            case 3://向左
//                g.fill3DRect(x,y,60,10,false);
//                g.fill3DRect(x,y + 30,60,10,false);
//                g.fill3DRect(x + 10,y + 10,40,20,false);
//                g.fillOval(x + 20,y + 10,20,20);
//                g.drawLine(x + 30,y + 20, x, y + 20);
//                break;
//            default:
//                System.out.println("其他的暂时不做处理");
//        }
//    }
//
//
//    /**
//     *
//     * @param x 坦克炮筒的左上角坐标
//     * @param y 坦克炮筒的左上角坐标
//     * @param g 画笔
//     * @param direct  方向 【0：向上，1：向右，2：向下，3：向左】
//     * @param type  坦克类型 【1：我们的子弹，0：敌人的子弹】
//     */
//    public void drawBullet(int x, int y, Graphics g, int direct, int type) {
//        switch (type) {
//            case 0:
//                g.setColor(Color.cyan);//敌人的：青色
//                break;
//            case 1:
//                g.setColor(Color.yellow);//我们的：黄色
//        }
//
//        //根据坦克的方向绘制子弹
//        switch (direct) {
//            case 0://向上
//                g.drawLine(x,y, x, y - 5);
//                break;
//            case 1://向右
//                g.drawLine(x,y, x + 5, y);
//                break;
//            case 2://向下
//                g.drawLine(x,y, x, y + 5);
//                break;
//            case 3://向左
//                g.drawLine(x,y, x - 5, y);
//                break;
//            default:
//                System.out.println("其他的暂时不做处理");
//        }
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        //System.out.println(e.getKeyChar());
//        //根据用户按下的建 进行移动
//        if (e.getKeyCode() == KeyEvent.VK_S) {
//            //s 下移
//            hero.setDirect(2);
//            //hero.setY(hero.getY() + 1); //too low
//            hero.moveDown();
//        } else if (e.getKeyCode() == KeyEvent.VK_W) {
//            //w 上移
//            hero.setDirect(0);
//            //hero.setY(hero.getY() - 1);
//            hero.moveUp();
//        } else if (e.getKeyCode() == KeyEvent.VK_A) {
//            //a 左
//            hero.setDirect(3);
//            //hero.setX(hero.getX() - 1);
//            hero.moveLeft();
//        } else if (e.getKeyCode() == KeyEvent.VK_D) {
//            //d 右移
//            hero.setDirect(1);
//            //hero.setX(hero.getX() + 1);
//            hero.moveRight();
//        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {//按空格键进行射击
//            System.out.println("开始射击");
//            //子弹移动
//            hero.shot();
//            //画出子弹
//            new Thread(this).start();
//        }
//        //改变坐标后需要重新绘制 坦克
//        this.repaint();//或者repaint(),不过加this更容易理解
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
//}
//
//
