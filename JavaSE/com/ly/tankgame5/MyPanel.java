package com.ly.tankgame5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @Author : Ly
 * @Date : 2022/3/23
 * @Description : 画板，用于绘制图形
 */

//KeyListener 监听键盘
public class MyPanel extends JPanel implements KeyListener, Runnable{
    //定义我的坦克
    static MyTank hero = null;
    //定义敌人的坦克  放到Vector集合中
    static Vector<EnemyTank> enemyTanks = new Vector<>();
    //初始化敌人坦克数量
    static int enemyTankSize = 4;
    //定义一个Vector，用于存放炸弹 .
        //说明，当子弹击中坦克时，加入一个Bomb对象到bombs中
    static Vector<Bomb> bombs = new Vector<>();
    //Recorder类

    //定义三张炸弹图片，用于显示爆炸效果
    static Image image1 = null;
    static Image image2 = null;
    static Image image3 = null;

    public MyPanel() {
        hero = new MyTank(500,80, 0);//初始化自己的坦克 [横纵坐标]
        //获取上一次得分
        //Recorder.readScore();
        //初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0, 2);
            enemyTanks.add(enemyTank);//先初始化对象，然后再是画图形
            //初始化敌人坦克时， 启动线程
            new Thread(enemyTank).start();

            Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            //把子弹加入敌人坦克下的子弹数组
            enemyTank.bulletsList.add(bullet);
            //启动该子弹线程
            new Thread(bullet).start();
        }

        //初始化图片
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

        playMusic();
    }

    public MyPanel(String[] s) {
        //185 0 3 0
        //201 75 0 0
        //199 74 3 1
        //画出上局坦克
        if ( s == null || s.length == 0) {
            new MyPanel();
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null) {
                System.out.println(s[i]);
                int x= Integer.parseInt(s[i].split(" ")[0]);
                int y= Integer.parseInt(s[i].split(" ")[1]);
                int direct= Integer.parseInt(s[i].split(" ")[2]);
                int type= Integer.parseInt(s[i].split(" ")[3]);
                if (type == 1) {
                    hero = new MyTank(x,y, direct);//初始化自己的坦克 [横纵坐标]
                    continue;//不然每次都会多一个
                }
                EnemyTank enemyTank = new EnemyTank(x, y, direct);
                enemyTanks.add(enemyTank);//先初始化对象，然后再是画图形
                //初始化敌人坦克时， 启动线程
                new Thread(enemyTank).start();

                Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                //把子弹加入敌人坦克下的子弹数组
                enemyTank.bulletsList.add(bullet);
                //启动该子弹线程
                new Thread(bullet).start();
            }

        }
        if (hero == null) {
            new MyPanel();
            return;
        }

        //初始化图片
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
        playMusic();
    }

    // 播放背景音乐
    public void playMusic() {
        new AePlayWave("src\\com\\ly\\tankgame5\\111.wav").start();
    }


    //继承画笔 用于绘图
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        showInfo(g);
        g.fillRect(0,0,1000,750);//填充矩形

        //画出我的坦克-封装方法  仅当我的坦克存活
        if (hero != null && hero.isLive) {
            drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),1);
        }

        //画出hero射击的子弹
        Bullet b = hero.bullet;
        if((b != null) && b.isLive ) {
            //System.out.println("***" + b);
            drawBullet(b.x,b.y,super.getGraphics(),b.direct,1);
        }

        //画出hero射击的子弹集合 便利


        //画出炸弹  如果集合中有炸弹就画出，每画出一次 炸弹的血量-1
        //      [所以坦克的生命减少就是在paint循环中逐渐-1到0的]
        if (bombs.size() != 0) {
            for (int i = 0; i < bombs.size(); i++) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Bomb bomb = bombs.get(i);//如果炸弹不为空，拿出一个炸弹
                //根据当前这个bomb对象的life值去画出对应的图片
                if (bomb.life > 6) {
                    g.drawImage(image1, bomb.x, bomb.y,60, 60, this);
                } else if (bomb.life > 3) {
                    g.drawImage(image2, bomb.x, bomb.y,60, 60, this);
                } else {
                    g.drawImage(image3, bomb.x, bomb.y,60, 60, this);
                }
                //让炸弹的生命值减一下
                bomb.lifeDown();
                if (bomb.life == 0) {
                    bombs.remove(bomb);
                }
            }
        }

        //画出敌人的坦克  遍历Vector集合
        for (int k = 0;k < enemyTanks.size();k++) {
            EnemyTank enemy = enemyTanks.get(k);
            //子弹-敌人坦克 射击判断
            if (b != null && b.isLive) {//我的子弹不为空，而且我的子弹活着
                hitTank(b,enemy);
            }

            if (enemy.isLive) {//只画出有效的坦克
                drawTank(enemy.getX(),enemy.getY(),g,enemy.getDirect(),0);
            } else { //如果坦克不存活，一定要将从集合中去掉 否则界面不显示但是子弹到这个区域还是会消失
                enemyTanks.remove(enemy);
            }
            //将敌人坦克 传递给每个敌人坦克的集合中
            enemy.setEnemyTanks(enemyTanks);
            //取出每个坦克的子弹集合
            for (int i = 0;i < enemy.bulletsList.size();i++) {
                Bullet bullet_enemy = enemy.bulletsList.get(i);
                if (bullet_enemy.isLive) {
                    drawBullet(bullet_enemy.x,bullet_enemy.y,g,bullet_enemy.direct,0);

                    //画出敌人子弹同时，判断是否敌人子弹击中了我方子弹
                    hitTank(bullet_enemy,hero);

                } else {
                    enemy.bulletsList.remove(bullet_enemy);//如果子弹失效，就要从里面移除掉
                }
            }
        }

    }

    @Override
    public void run() {
        //主要作用就是重绘
        while (true) {

            this.repaint();
            //得分
//            if (!hero.isLive) {
//                Recorder.scoreRecord();
//                break;
//            }

            //双层for循环判断敌人坦克的位置和方向，防止重叠
//            for (int i = 0; i < enemyTanks.size() - 1; i++) {
//                EnemyTank et1 = enemyTanks.get(i);
//                for (int j = i + 1; j < enemyTanks.size(); j++) {
//                    EnemyTank et2 = enemyTanks.get(i);
//                    //8种组合
//                    switch (et1.getDirect()) {
//                        case 2:
//                        case 0:
//                            switch (et2.getDirect()) {
//                                case 0:
//                                case 2:
//                                    if (!((Math.abs(et1.getX() - et2.getX()) >= 40) || (Math.abs(et1.getY() - et2.getY()) >= 60))) {
//                                        et1.setDirect(1);
//                                        et1.moveRight();
//                                    }
//                                    break;
//                                case 1:
//                                case 3:
//                                    if (!((Math.abs(et1.getX() - et2.getX()) >= 50) || (Math.abs(et1.getY() - et2.getY()) >= 50))) {
//                                        et2.setDirect(3);
//                                        et1.moveLeft();
//                                    }
//                                    break;
//                            }
//                            break;
//                        case 3:
//                        case 1:
//                            switch (et2.getDirect()) {
//                                case 0:
//                                case 2:
//                                    if (!((Math.abs(et1.getX() - et2.getX()) >= 50) || (Math.abs(et1.getY() - et2.getY()) >= 50))) {
//                                        et1.setDirect(1);
//                                        et1.moveRight();
//                                    }
//                                    break;
//                                case 1:
//                                case 3:
//                                    if (!((Math.abs(et1.getX() - et2.getX()) >= 60) || (Math.abs(et1.getY() - et2.getY()) >= 40))) {
//                                        et2.setDirect(3);
//                                        et1.moveLeft();
//                                    }
//                                    break;
//                            }
//                            break;
//                    }
//                }
//            }
//            this.repaint();
        }

    }

    /**
     *
     * @param x 坦克的左上角坐标
     * @param y 坦克的左上角坐标
     * @param g 画笔
     * @param direct  方向 【0：向上，1：向右，2：向下，3：向左】
     * @param type  坦克类型 【1：我们的坦克，0：敌人的坦克】
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
        }

        //根据坦克的方向绘制坦克
        switch (direct) {
            case 0://向上
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x + 30,y,10,60,false);
                g.fill3DRect(x + 10,y + 10,20,40,false);
                g.fillOval(x + 10,y + 20,20,20);
                g.drawLine(x + 20,y + 30, x + 20, y);
                break;
            case 1://向右
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x,y + 30,60,10,false);
                g.fill3DRect(x + 10,y + 10,40,20,false);
                g.fillOval(x + 20,y + 10,20,20);
                g.drawLine(x + 30,y + 20, x + 60, y + 20);
                break;
            case 2://向下
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x + 30,y,10,60,false);
                g.fill3DRect(x + 10,y + 10,20,40,false);
                g.fillOval(x + 10,y + 20,20,20);
                g.drawLine(x + 20,y + 30, x + 20, y + 60);
                break;
            case 3://向左
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x,y + 30,60,10,false);
                g.fill3DRect(x + 10,y + 10,40,20,false);
                g.fillOval(x + 20,y + 10,20,20);
                g.drawLine(x + 30,y + 20, x, y + 20);
                break;
            default:
                System.out.println("其他的暂时不做处理");
        }
    }

    /**
     *
     * @param g 画笔
     * 编写方法，显示我方击毁敌方坦克的信息
     */
    public void showInfo(Graphics g) {
        //画出玩家的总成绩
        g.setColor(Color.BLACK);//设置文字颜色
        Font font = new Font("宋体", Font.BOLD, 25);//设置文字字体
        g.setFont(font);
        g.drawString("累计击毁敌方坦克",1020,30);
        drawTank(1020,60,g,0,0);//画出一个敌方坦克
        g.setColor(Color.BLACK); //颜色要回来 不然就是蓝色了
        g.drawString("X " + Recorder.getScore(),1100,100);

    }

    /**
     *
     * @param x 坦克炮筒的左上角坐标
     * @param y 坦克炮筒的左上角坐标
     * @param g 画笔
     * @param direct  方向 【0：向上，1：向右，2：向下，3：向左】
     * @param type  坦克类型 【1：我们的子弹，0：敌人的子弹】
     */
    public void drawBullet(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                 g.setColor(Color.cyan);//敌人的：青色
                break;
            case 1:
                g.setColor(Color.yellow);//我们的：黄色
        }

        //根据坦克的方向绘制子弹
        switch (direct) {
            case 0://向上
                g.drawLine(x,y, x, y - 5);
                break;
            case 1://向右
                g.drawLine(x,y, x + 5, y);
                break;
            case 2://向下
                g.drawLine(x,y, x, y + 5);
                break;
            case 3://向左
                g.drawLine(x,y, x - 5, y);
                break;
            default:
                System.out.println("其他的暂时不做处理");
        }
    }

    /**
     * 编写方法，判断我方子弹是否已经击中敌人
     * @param b 子弹
     * @param enemyTank 坦克
     */
    public static void hitTank(Bullet b, Tank enemyTank) {
        //判断击中敌人
        switch (enemyTank.getDirect()) {
            case 0://向上 同样的范围
            case 2://向下
                if (b.x > enemyTank.getX() && b.x < enemyTank.getX() + 40
                        && b.y > enemyTank.getY() && b.y < enemyTank.getY() + 60) {
                    b.isLive = false;//子弹销毁
                    enemyTank.isLive = false;
                    //创建Bomb对象，加入到bombs集合中
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);

                    //判断击中的是否为我方坦克类型
                    if (enemyTank instanceof EnemyTank) {
                        //System.out.println("击中敌方坦克");
                        Recorder.addScore();
                    }
                }
                break;
            case 3://向左
            case 1://向右
                if (b.x > enemyTank.getX() && b.x < enemyTank.getX() + 60
                        && b.y > enemyTank.getY() && b.y < enemyTank.getY() + 40) {
                    b.isLive = false;//子弹销毁
                    enemyTank.isLive = false;
                    //创建Bomb对象，加入到bombs集合中
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);

                    //判断击中的是否为我方坦克类型
                    if (enemyTank instanceof EnemyTank) {
                        Recorder.addScore();
                    }
            }
        }

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyChar());
        //根据用户按下的建 进行移动
        if (e.getKeyCode() == KeyEvent.VK_S) {
            //s 下移
            hero.setDirect(2);
            //hero.setY(hero.getY() + 1); //too low
            if (hero.getY() + 60 < 750) {
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            //w 上移
            hero.setDirect(0);
            //hero.setY(hero.getY() - 1);
            if (hero.getY() > 0) {
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            //a 左
            hero.setDirect(3);
            //hero.setX(hero.getX() - 1);
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            //d 右移
            hero.setDirect(1);
            //hero.setX(hero.getX() + 1);
            if (hero.getX() + 60 < 1000) {
                hero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {//按空格键进行射击
            //System.out.println("开始射击");

            //仅在当前子弹消亡后才可以再次发射子弹 【我方子弹为空，或子弹消亡了 才可以重新发射】
            if (hero.bullet == null || !hero.bullet.isLive) {
                //子弹移动
                hero.shot();
                //画出子弹  已经在主方法中运用，此处可省略
                //new Thread(this).start();
            }

            //发射多颗子弹
            //hero.shot();
        }
        //改变坐标后需要重新绘制 坦克
        this.repaint();//或者repaint(),不过加this更容易理解
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


