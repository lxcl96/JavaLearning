package chapter16_TankGame_.draw_;

import javax.swing.*;
import java.awt.*;

/**
 * @FileName:drawCircle.class
 * @Author:ly
 * @Date:2022/3/14
 * @Description:演示绘图画圆
 */
@SuppressWarnings({"all"})
//extends JFrame 用来创建一个窗口
public class drawCircle extends JFrame{

    private MyPanel mp = null;
    public static void main(String[] args) {
        new drawCircle();
    }

    //定义窗口大小
    public drawCircle() {
        mp = new MyPanel();//创建画布
        this.add(mp);//把画布放入窗口
        this.setSize(400, 300);//定义窗口大小
        this.setVisible(true);//让窗口可视
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击窗口的x 退出程序
    }
}

    //说明：
    //1、MyPanel就是一个面板/画板
    //2、Graphics g理解成一个画笔
    //3、Graphics提供了很多绘画方法
//1、先定义一个MyPanel，继承JPanel，画圆形就在面板上画
class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//调用父类的方法完成初始化
        g.drawOval(0, 0, 100, 100);//左上角点的x和y
    }
}