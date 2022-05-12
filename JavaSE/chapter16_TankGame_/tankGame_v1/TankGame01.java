package chapter16_TankGame_.tankGame_v1;

import javax.swing.*;

/**
 * @FileName:TankGame01.class
 * @Author:ly
 * @Date:2022/3/14
 * @Description:
 */
public class TankGame01 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new TankGame01();
    }
    public TankGame01() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
