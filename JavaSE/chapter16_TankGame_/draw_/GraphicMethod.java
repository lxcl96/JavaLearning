package chapter16_TankGame_.draw_;

import javax.swing.*;
import java.awt.*;

/**
 * @FileName:GraphicMethod.class
 * @Author:ly
 * @Date:2022/3/14
 * @Description:
 */
/*
JFrame就是窗口，让画的图形现实出来
 */
public class GraphicMethod extends JFrame{
        MP mp = null;

        /*
        画图步骤：
        1、设置显示窗口大小
        2、把画板画好的放进窗口中
        3、让窗口可视化

         */
    public GraphicMethod() {
        mp = new MP();
        this.setSize(600, 300);
        this.add(mp);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GraphicMethod();
    }
}
/*
JPanel就是画板，在其paint方法中画出各种图形
 */
class MP extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.setFont(new Font("隶书",Font.BOLD, 50));//字体 格式 大小
        g.drawLine(10,10, 40, 40);
        g.drawRect(10,10, 30, 30);
        g.drawOval(10,50, 30, 30);
        //g.setFont();//设置字体
        g.fillRect(50, 10, 30, 30);
        g.fillOval(10, 80, 30, 30);

        g.drawString("你好吗？", 10, 120);  //xy是左下角 而不是左上角
        //1、获取图片  /表示根目录
        Image image = Toolkit.getDefaultToolkit().getImage(MP.class.getResource("/chapter16_TankGame_/draw_/Java绘图技术.png"));
        g.drawImage(image, 10, 150, 30, 50, this); //this表示当前位置
    }
}