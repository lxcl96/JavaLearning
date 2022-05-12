package chapter16_TankGame_.draw_;

import javax.swing.*;
import java.awt.*;

/**
 * @FileName:HomeWork01.class
 * @Author:ly
 * @Date:2022/3/14
 * @Description:画出坦克样子
 */
public class HomeWork01 extends JFrame{
    public HomeWork01() {
        JPanel mp = new Tanke();
        this.setSize(600,450);
        this.add(mp);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new HomeWork01();
    }

}

class Tanke extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.cyan);
        g.fillRect(10,10, 10,20);
        g.fillRect(30,10, 10,20);
        g.fillRect(20,16, 10,10);
        g.drawLine(25, 20, 25, 10);
        g.setColor(Color.BLUE);
        g.fillOval(20, 16, 8, 8);
    }
}