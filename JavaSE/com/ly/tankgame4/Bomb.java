package com.ly.tankgame4;

/**
 * @Author : Ly
 * @Date : 2022/3/31
 * @Description : 实现坦克被击中爆炸效果
 */
public class Bomb {
    int x, y;
    int life = 9;//炸弹的生命周期
    boolean isLive = true;//是否存活

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Jiangxi·减少生命值
    public void lifeDown() {
        if (life > 0) {
            life--;
        } else {
            isLive = false;
        }
    }
}
