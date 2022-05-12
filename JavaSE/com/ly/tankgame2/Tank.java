package com.ly.tankgame2;

/**
 * @Author : Ly
 * @Date : 2022/3/22
 * @Description : 坦克父类，定义基本信息
 */
public class Tank {
    private int x; //坦克的横坐标
    private int y; //坦克的纵坐标
    private int direct;//坦克的方向
    private int speed = 1;//坦克的移动速度，初始化为1

    public Tank(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }



    //定义坦克的移动方法
    public void moveUp() {y -= speed;}
    public void moveDown() {y += speed;}
    public void moveLeft() {x -= speed;}
    public void moveRight() {x += speed;}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
