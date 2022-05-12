package com.ly.tankgame5;

import java.util.Vector;

/**
 * @Author : Ly
 * @Date : 2022/3/23
 * @Description : 敌人坦克
 */
public class EnemyTank extends Tank implements Runnable{
    Vector<Bullet> bulletsList = new Vector<>();//存放多个子弹变量
    //增加成员，enemyTanks 可以得到敌人坦克的Vector [其实就是MyPanel类中的enemyTanks 这里是做到互通]
    Vector<EnemyTank> enemyTanks = new Vector<>();

    public EnemyTank(int x, int y, int direct) {
        super(x, y, direct);
    }

    //这里提供一个方法，可以讲MyPanel类中的Vector<EnemyTank> enemyTanks = new Vector<>(); 赋值过来
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    //编写方法，判断当前这个敌人坦克，是否和enemy中的其他坦克发生重叠
    public Boolean isTouchEnemyTank() {
        switch (this.getDirect()) {
            case 0:
                //取出所有的坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank == this)
                        continue;
                    //【坦克是一个长40 宽60px的矩形，给予上面左右两个点来判断】
                    //如果敌人坦克是上下方向  左点坐标
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        //此时敌人坦克的左上角坐标为（this.getx(),this.getY()）
                        //两个矩形比较
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }

                    }
                    //如果敌人坦克是上下方向  右点坐标
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        //此时敌人坦克的右上角坐标为（this.getx() + 40,this.getY()）
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }
                    }

                    //如果敌人坦克是左右方向   左点坐标
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        //此时敌人坦克的左上角坐标为（this.getx(),this.getY()）
                        //两个矩形比较
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }

                    }
                    //如果敌人坦克是左右方向  右点坐标
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        //此时敌人坦克的右上角坐标为（this.getx() + 40,this.getY()）
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }
                    }

                }
                break;
            case 1:
                //取出所有的坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank == this)
                        continue;
                    //【坦克是一个长40 宽60px的矩形，给予上面左右两个点来判断】
                    //如果敌人坦克是上下方向  左点坐标
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        //此时敌人坦克的右上角坐标为（this.getx() + 60,this.getY()）
                        //两个矩形比较
                        if (this.getX() + 60 >= enemyTank.getX()
                                && this.getX() + 60 <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }

                    }
                    //如果敌人坦克是上下方向  右点坐标
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        //此时敌人坦克的右下角坐标为（this.getx() + 60,this.getY() + 40）
                        if (this.getX() + 60 >= enemyTank.getX()
                                && this.getX() + 60 <= enemyTank.getX() + 40
                                && this.getY() + 40 >= enemyTank.getY()
                                && this.getY() + 40 <= enemyTank.getY() + 60) {
                            return true;
                        }
                    }

                    //如果敌人坦克是左右方向   左点坐标
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        //此时敌人坦克的右上角坐标为（this.getx() + 60,this.getY()）
                        //两个矩形比较
                        if (this.getX() + 60 >= enemyTank.getX()
                                && this.getX() + 60 <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }

                    }
                    //如果敌人坦克是左右方向  右点坐标
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        //此时敌人坦克的右下角坐标为（this.getx() + 60,this.getY() + 40）
                        if (this.getX() + 60 >= enemyTank.getX()
                                && this.getX() + 60 <= enemyTank.getX() + 60
                                && this.getY() + 40 >= enemyTank.getY()
                                && this.getY() + 40 <= enemyTank.getY() + 40) {
                            return true;
                        }
                    }

                }
                break;
            case 2:
                //取出所有的坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank == this)
                        continue;
                    //【坦克是一个长40 宽60px的矩形，给予上面左右两个点来判断】
                    //如果敌人坦克是上下方向  左点坐标
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        //此时敌人坦克的左下角坐标为（this.getx(),this.getY() + 60）
                        //两个矩形比较
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY() + 60 >= enemyTank.getY()
                                && this.getY() + 60 <= enemyTank.getY() + 60) {
                            return true;
                        }

                    }
                    //如果敌人坦克是上下方向  右点坐标
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        //此时敌人坦克的右下角坐标为（this.getx() + 40,this.getY() + 60）
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 40
                                && this.getY() + 60 >= enemyTank.getY()
                                && this.getY() + 60 <= enemyTank.getY() + 60) {
                            return true;
                        }
                    }

                    //如果敌人坦克是左右方向   左点坐标
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        //此时敌人坦克的左下角坐标为（this.getx(),this.getY() + 60）
                        //两个矩形比较
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 60
                                && this.getY() + 60 >= enemyTank.getY()
                                && this.getY() + 60 <= enemyTank.getY() + 40) {
                            return true;
                        }

                    }
                    //如果敌人坦克是左右方向  右点坐标
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        //此时敌人坦克的右下角坐标为（this.getx() + 40,this.getY() + 60）
                        if (this.getX() + 40 >= enemyTank.getX()
                                && this.getX() + 40 <= enemyTank.getX() + 60
                                && this.getY() + 60 >= enemyTank.getY()
                                && this.getY() + 60<= enemyTank.getY() + 40) {
                            return true;
                        }
                    }

                }
                break;
            case 3:
                //取出所有的坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank == this)
                        continue;
                    //【坦克是一个长40 宽60px的矩形，给予上面左右两个点来判断】
                    //如果敌人坦克是上下方向  左点坐标
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        //此时敌人坦克的左上角坐标为（this.getx(),this.getY()）
                        //两个矩形比较
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 60) {
                            return true;
                        }

                    }
                    //如果敌人坦克是上下方向  右点坐标
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        //此时敌人坦克的左下角坐标为（this.getx(),this.getY() + 40）
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 40
                                && this.getY() + 40 >= enemyTank.getY()
                                && this.getY() + 40 <= enemyTank.getY() + 60) {
                            return true;
                        }
                    }

                    //如果敌人坦克是左右方向   左点坐标
                    if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                        //此时敌人坦克的左上角坐标为（this.getx() ,this.getY()）
                        //两个矩形比较
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() + 40) {
                            return true;
                        }

                    }
                    //如果敌人坦克是左右方向  右点坐标
                    if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                        //此时敌人坦克的右下角坐标为（this.getx(),this.getY() + 40）
                        if (this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() + 60
                                && this.getY() + 40 >= enemyTank.getY()
                                && this.getY() + 40 <= enemyTank.getY() + 40) {
                            return true;
                        }
                    }

                }
                break;



        }
        return false;
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
                        if (super.getY() > 0 && !isTouchEnemyTank()) {
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
                        if (super.getX() + 60 < 1000 && !isTouchEnemyTank()) {
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
                        if (super.getY() + 60 < 750 && !isTouchEnemyTank()) {
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
                        if (super.getX() > 0 && !isTouchEnemyTank()) {
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

            //太早了，需要休眠一下
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //补充敌人的子弹，当子弹消失了，可以再次发射子弹
            //如果子弹集合为空
            if (this.bulletsList == null || this.bulletsList.size() == 0) {
                //需要根据当前方向创建子弹
                Bullet b = null;
                //Bullet b = new Bullet(this.getX() + 20, this.getY() + 60, this.getDirect());
                switch (this.getDirect()) {
                    case 0:
                        b = new Bullet(this.getX() + 20, this.getY(), this.getDirect());
                        break;
                    case 1:
                        b = new Bullet(this.getX() + 60, this.getY() + 20, this.getDirect());
                        break;
                    case 2:
                        b = new Bullet(this.getX() + 20, this.getY() + 60, this.getDirect());
                        break;
                    case 3:
                        b = new Bullet(this.getX(), this.getY() + 20, this.getDirect());
                        break;
                }

                //把子弹加入敌人坦克下的子弹数组
                this.bulletsList.add(b);
                //启动该子弹线程
                new Thread(b).start();
            }

        }

        //System.out.println("敌人坦克线程 " + Thread.currentThread().getName() + "已经退出了");
    }

    //因为现在坦克只向下，所以不考虑别的方向子弹，放在MyPanel中初始化EnemyTank时创建

}
