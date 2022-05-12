package com.ly.tankgame5;

/**
 * @Author : Ly
 * @Date : 2022/3/30
 * @Description : 子弹属性
 */
public class Bullet implements Runnable{
    int x;//子弹坐标
    int y;
    int direct;//子弹方向
    int speed = 1;//子弹速度
    boolean isLive = true;//记录当前子弹是否存活

    public Bullet(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(50);//线程休眠，为了显示子弹轨迹
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //越界结束子弹线程
            //if(!(x >= 0 && x <= 1000 && y >= 0 && y <= 750))
            if (x <= 0 || y <= 0 || x >= 1000 || y >= 750 || !isLive) {//退出子弹线程，比不画出来更好
                System.out.println("子弹 " + Thread.currentThread().getName() + "退出了！");
                isLive = false;//当前子弹不存活了
                break;
            }
            //根据方向来改动方向坐标
            switch (direct) {
                case 0://向上
                    y -= speed;
                    break;
                case 1://向右
                    x += speed;
                    break;
                case 2://向下
                    y += speed;
                    break;
                case 3://向左
                    x -= speed;
                    break;
                default:
                    System.out.println("其他的暂时不做处理");
            }
            //System.out.println("子弹 " + Thread.currentThread().getName() + "当前坐标为（" + x + "," + y + ")");

        }
    }
}
