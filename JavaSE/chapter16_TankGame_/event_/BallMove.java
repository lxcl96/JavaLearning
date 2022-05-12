package chapter16_TankGame_.event_;

import javax.swing.*;
import java.awt.*;

/**
 * @FileName:BallMove.class
 * @Author:ly
 * @Date:2022/3/14
 * @Description: 事件处理机制【小球移动】
 */
public class BallMove extends JFrame{
    MyPanel mp = null;

    public BallMove(){
        mp = new MyPanel();
        //this.setSize();
        this.add(mp);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BallMove();
    }
}

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(10,10,20,20);
    }
}
