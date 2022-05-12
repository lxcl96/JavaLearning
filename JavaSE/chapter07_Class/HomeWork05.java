package chapter07_Class;

public class HomeWork05 {
    public static void main(String[] args) {
        circle c = new circle();
        double semi = 1;
        Double d = c.girthGet(semi);
        if (d == null)
            System.out.println("非法半径" + semi + ",请输入正确半径");
        else
            System.out.println("圆周长为：Π * " + semi + " * 2 = " + d);
        new circle().info();
    }
}
//定义一个圆类circle 定义属性：半径，提供显示圆周长和面积的方法
class circle {
    double semi;
    public Double girthGet(double semi) {
        if (semi > 0) {
            return semi *2 * Math.PI;
        }
        return null;
    }
    public void info() {
        System.out.println(11111);
    }
}